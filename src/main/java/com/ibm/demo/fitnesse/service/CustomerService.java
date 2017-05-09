package com.ibm.demo.fitnesse.service;

public interface CustomerService {
	
	int createCustomer(String customerName);
	int getCustomerId(String customerName);
	int deleteCustomer(String customerName);
	
}
