package com.javaegitimleri.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="phone_no", nullable = false)
    private String phoneNo;

    @Column(name="residential_address_1", nullable = false)
    private String residentialAddress1;

    @Column(name="residential_address_2", nullable = false)
    private String residentialAddress2;

    @Column(name="residential_address_3", nullable = false)
    private String residentialAddress3;
    
    @Column(name="mailing_address_1", nullable = false)
    private String mailingAddress1;

    @Column(name="mailing_address_2", nullable = false)
    private String mailingAddress2;

    @Column(name="mailing_address_3", nullable = false)
    private String mailingAddress3;
    
    @Column(name="status", nullable = false)
    private String status;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phoneNo=");
		builder.append(phoneNo);
		builder.append(", residentialAddress1=");
		builder.append(residentialAddress1);
		builder.append(", residentialAddress2=");
		builder.append(residentialAddress2);
		builder.append(", residentialAddress3=");
		builder.append(residentialAddress3);
		builder.append(", mailingAddress1=");
		builder.append(mailingAddress1);
		builder.append(", mailingAddress2=");
		builder.append(mailingAddress2);
		builder.append(", mailingAddress3=");
		builder.append(mailingAddress3);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getResidentialAddress1() {
		return residentialAddress1;
	}

	public void setResidentialAddress1(String residentialAddress1) {
		this.residentialAddress1 = residentialAddress1;
	}

	public String getResidentialAddress2() {
		return residentialAddress2;
	}

	public void setResidentialAddress2(String residentialAddress2) {
		this.residentialAddress2 = residentialAddress2;
	}

	public String getResidentialAddress3() {
		return residentialAddress3;
	}

	public void setResidentialAddress3(String residentialAddress3) {
		this.residentialAddress3 = residentialAddress3;
	}

	public String getMailingAddress1() {
		return mailingAddress1;
	}

	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}

	public String getMailingAddress2() {
		return mailingAddress2;
	}

	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}

	public String getMailingAddress3() {
		return mailingAddress3;
	}

	public void setMailingAddress3(String mailingAddress3) {
		this.mailingAddress3 = mailingAddress3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
