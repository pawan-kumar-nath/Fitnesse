package com.ibm.demo.fitnesse.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.demo.fitnesse.dao.AccountDao;
import com.ibm.demo.fitnesse.util.JdbiDaoConfiguration;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private JdbiDaoConfiguration jdbiDaoConfiguration;
	private AccountDao accountDao;
	
	@PostConstruct
	public void postConstruct() throws Exception {
		accountDao = jdbiDaoConfiguration.getDao(AccountDao.class);
	}

	@Override
	public int getBalanceByCustomerName(String customerName) {
		return accountDao.getBalanceByCustomerName(customerName);
	}

}
