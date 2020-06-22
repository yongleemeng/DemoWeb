package com.javaegitimleri.app.dao;

import java.util.List;

import com.javaegitimleri.app.model.Transaction;

public interface TransactionRepository {

	Transaction findById(String id );
	List<Transaction> searchTransactions(Transaction trx);
	void create(Transaction pet);
	Transaction update(Transaction trx);
	void delete(String id );
	
	
	
}
