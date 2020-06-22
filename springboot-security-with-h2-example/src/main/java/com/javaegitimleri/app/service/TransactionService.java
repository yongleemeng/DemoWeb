package com.javaegitimleri.app.service;

import java.util.List;

import com.javaegitimleri.app.common.CommonRollbackException;
import com.javaegitimleri.app.model.Transaction;

public interface TransactionService {

	List<Transaction> searchTransactions(Transaction trx);
	Transaction findById(String id) throws CommonRollbackException;
	void createTransaction(Transaction trx);
	Transaction update(Transaction trx);
	void delete(String id);
	

}
