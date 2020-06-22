package com.javaegitimleri.app.dao.jpa;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.javaegitimleri.app.common.CommonSortingModel;
import com.javaegitimleri.app.common.CommonWebConstants;
import com.javaegitimleri.app.common.CommonWebUtils;
import com.javaegitimleri.app.dao.TransactionRepository;
import com.javaegitimleri.app.model.Transaction;


@Repository("transactionRepository")
public class TransactionRepositoryJpaImp implements TransactionRepository {

	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public Transaction findById(String id) {
		return entitymanager.find(Transaction.class, id);
	}

	@Override
	public List<Transaction> searchTransactions(Transaction trx) {
		String accountNumber = trx.getAccountNumber();
		String customerName = trx.getCustomerName();
		String fromDate = trx.getFromDate();
		String toDate = trx.getToDate();
		int pageNo = trx.getPageNo();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT t.* FROM TRANSACTIONS t ");
		sb.append("INNER JOIN CUSTOMER c ON c.id = t.customer_id ");;
		sb.append("WHERE 1=1 ");

		if (!StringUtils.isEmpty(accountNumber)) {
			sb.append("AND t.account_number = :accountNumber ");
		}
		
		if (!StringUtils.isEmpty(customerName)) {
			sb.append("AND c.name like :customerName ");
		}

		if (!StringUtils.isEmpty(fromDate)) {
			sb.append("AND t.create_date >= :fromDate ");
		}

		if (!StringUtils.isEmpty(toDate)) {
			sb.append("AND t.create_date <= :toDate ");
		}
		
		//sb.append(CommonWebUtils.contructPagination(pageNo, CommonWebConstants.PAGINATION_LIST_SIZE));
		sb.append(CommonWebUtils.contructPagination(pageNo, 10));

		if (!StringUtils.isEmpty(trx.getSortingList())) {
			
			boolean first = true;
			for (CommonSortingModel sort : trx.getSortingList()) {
				String alias = "";
				if (sort.getField().equals(Transaction.SORT_ACCOUNT_NUMBER)){
					alias = "t." ;
				}
				
				if (!first) {
					sb.append(", ");
				}
				sb.append(sort.contructSorting(alias));
				
				first = false;
			}
		} else {
			sb.append("t.create_date desc ");
		}
		
		Query q = entitymanager.createNativeQuery(sb.toString(),  Transaction.class);

		if (!StringUtils.isEmpty(accountNumber)) {
			q = q.setParameter("accountNumber", accountNumber);
		}
		
		if (!StringUtils.isEmpty(customerName)) {
			q = q.setParameter("customerName", customerName);
		}

		if (!StringUtils.isEmpty(fromDate)) {
			q = q.setParameter("fromDate", fromDate);
		}

		if (!StringUtils.isEmpty(toDate)) {
			q = q.setParameter("toDate", toDate);
		}
		

		return q.getResultList();
	}

	@Override
	public void create(Transaction transaction) {
		entitymanager.persist(transaction);

	}

	@Override
	public Transaction update(Transaction transaction) {
		// TODO Auto-generated method stub
		return entitymanager.merge(transaction);
	}
	
	public void delete(String id) {
		entitymanager.remove(entitymanager.getReference(Transaction.class, id));
	}

	

}
