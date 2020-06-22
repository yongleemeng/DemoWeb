package com.javaegitimleri.app.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.app.common.CommonRollbackException;
import com.javaegitimleri.app.common.CommonWebConstants;
import com.javaegitimleri.app.common.CommonWebUtils;
import com.javaegitimleri.app.dao.TransactionRepository;
import com.javaegitimleri.app.dao.PetRepository;
import com.javaegitimleri.app.model.Transaction;

@Service
@Transactional(rollbackFor=Exception.class)
public class TransactionServiceImp implements TransactionService {
	private Logger logger = Logger.getLogger(TransactionServiceImp.class);
	
	private TransactionRepository transactionRepository;
	
	
	@Autowired
	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Transaction> searchTransactions(Transaction trx) {
		// TODO Auto-generated method stub
		return transactionRepository.searchTransactions(trx);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Transaction findById(String id) throws CommonRollbackException {
		// TODO Auto-generated method stub
		Transaction transaction=transactionRepository.findById(id);
		if (transaction==null) {
			logger.debug("CommonRollbackException: Transaction not found with id : "+id);
			throw new CommonRollbackException(CommonWebConstants.EXCEPTION_RECORD_NOT_FOUND); 
		}
			return transaction;
	}

	@Override
	public void createTransaction(Transaction trx) {
		transactionRepository.create(trx);

	}

	@Override
	public Transaction update(Transaction trx) {
		// TODO Auto-generated method stub
		return transactionRepository.update(trx);
	}

	@Override
	public void delete(String id) {
		transactionRepository.delete(id);

	}

}
