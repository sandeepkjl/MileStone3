package com.wipro.bank.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false)
	private int accountID;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_customerID", referencedColumnName="customerID")
	private Customer customer;
	private double balance;

	public Account() {
		super();
	}

	public Account(int accountID, Customer customer, double balance) {
		super();
		this.accountID = accountID;
		this.customer = customer;
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", customer=" + customer + ", balance=" + balance + "]";
	}
	
	
	
	
	
	

}
