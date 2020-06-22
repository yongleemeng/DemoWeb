package com.javaegitimleri.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.javaegitimleri.app.common.CommonAbstractModel;

@Entity(name = "TRANSACTIONS")
public class Transaction extends CommonAbstractModel{
	
	public static final String SORT_ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
	public static final String SORT_NAME = "NAME";
	public static final String SORT_FROM_DATE = "FROM_DATE";
	public static final String SORT_TO_DATE = "TO_DATE";
	
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(name="account_number", nullable = false)
    private String accountNumber;

    @Column(name="amount", nullable = false)
    private String amount;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="create_date", nullable = false)
    private Date date;
    
    @Transient
    private String customerName;
    
    @Transient
    private String fromDate;

    @Transient
    private String toDate;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [id=");
		builder.append(id);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date=");
		builder.append(date);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", fromDate=");
		builder.append(fromDate);
		builder.append(", toDate=");
		builder.append(toDate);
		builder.append(", customer=");
		builder.append(customer);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String contructSorting() {
		return null;
	}

    @ManyToOne
    @JoinColumn(name = "customer_id",
            nullable = false, updatable = false)
    private Customer customer;
    
    public void clone (Transaction transaction) {
    	this.accountNumber=transaction.getAccountNumber();
    	this.amount=transaction.getAmount();
    	this.description=transaction.getDescription();
    	this.customer = transaction.getCustomer();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


}
