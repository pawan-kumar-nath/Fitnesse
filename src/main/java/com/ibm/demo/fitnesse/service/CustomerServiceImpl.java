package com.ibm.demo.fitnesse.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.demo.fitnesse.dao.CustomerDao;
import com.ibm.demo.fitnesse.exception.DemoFitnesseException;
import com.ibm.demo.fitnesse.util.JdbiDaoConfiguration;

@Service
public class CustomerServiceImpl implements CustomerService{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbiDaoConfiguration jdbiDaoConfiguration;
	private CustomerDao customerDao;
	
	@PostConstruct
	public void postConstruct() throws Exception {
		customerDao = jdbiDaoConfiguration.getDao(CustomerDao.class);
	}
	
	public int createCustomer(String customerName) {
		LOG.info("Creating customer by name ["+customerName+"]");
		int customerId = getCustomerId(customerName);
		if(customerId == 0){
			return customerDao.createCustomer(customerName);
		}else{
			throw new DemoFitnesseException("Customer ["+customerName+"] already exists");
		}
		
	}

	public int getCustomerId(String customerName) {
		LOG.info("Checking customer by name ["+customerName+"]");
		return customerDao.getCustomerId(customerName);
	}

	@Override
	public int deleteCustomer(String customerName) {
		return customerDao.deleteCustomer(customerName);
	}

}
