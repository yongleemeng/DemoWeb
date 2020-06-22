package com.javaegitimleri.app.web;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaegitimleri.app.common.CommonRollbackException;
import com.javaegitimleri.app.common.CommonWebConstants;
import com.javaegitimleri.app.model.Transaction;
import com.javaegitimleri.app.service.TransactionService;

@RestController
@RequestMapping("/rest")
public class TransactionRestController {
	private Logger logger = Logger.getLogger(TransactionRestController.class);
	@Autowired
	private TransactionService appService;
	
	@GetMapping("/transactions")
	@ResponseBody
	public String getTransactions(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String description,
			@RequestParam(required = false) String accountNumber,
			@RequestParam(required = false) int pageNo){
		Transaction trx = new Transaction();
		trx.setAccountNumber(accountNumber);
		trx.setCustomerName(name);
		trx.setDescription(description);
		trx.setPageNo(pageNo);
		List<Transaction> transactions=appService.searchTransactions(trx);
		return transactions==null?"null":transactions.toString();
	}
	
	@RequestMapping(value="/transaction/{id}")
	@ResponseBody
	public String getTransaction(@PathVariable("id") String id){
		try {
			Transaction trx=appService.findById(id);
			return trx.toString();
		} catch (Exception e) {
			logger.error("getTransaction:",e);
			return e.getMessage();
		}
	}
	
	//delete transaction
	//@RequestMapping(method=RequestMethod.DELETE,value="/transaction/{id}")
	//@ResponseBody
	@RequestMapping(value="/transaction/delete/{id}")
	@ResponseBody
	public String deleteTransaction(@PathVariable("id") String id){
		
		try {
			appService.delete(id);
			
			return "Deleted " + id;
			
		} catch (CommonRollbackException e) {
			logger.debug("CommonRollbackException",e);
			if (CommonWebConstants.EXCEPTION_RECORD_NOT_FOUND.equals(e.getMessage())){
				return "CommonRollbackException.EXCEPTION_RECORD_NOT_FOUND";
			}
			return "CommonRollbackException";
			
		} catch (Exception e) {
			logger.error("deleteTransaction",e);
			return "Exception";
		}
	} 
	
	
	
	// update transaction
	@RequestMapping(method=RequestMethod.PUT,value="/transaction/{id}")
	public ResponseEntity<List<Transaction>> updateTransactions(@PathVariable("id") String id, @RequestBody Transaction transaction){
		try {
			Transaction trx=appService.findById(id);
			trx.clone(transaction);
			appService.update(trx);
			return ResponseEntity.ok().build();
		} catch (CommonRollbackException e) {
			if (CommonWebConstants.EXCEPTION_RECORD_NOT_FOUND.equals(e.getMessage())){
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
