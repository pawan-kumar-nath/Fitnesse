package com.ibm.demo.fitnesse.fixture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.demo.fitnesse.config.FixtureWirer;
import com.ibm.demo.fitnesse.exception.DemoFitnesseException;
import com.ibm.demo.fitnesse.restclient.AccountOperationClientService;
import com.ibm.demo.fitnesse.service.AccountService;
import com.ibm.demo.fitnesse.util.RestResponse;
import com.ibm.demo.fitnesse.util.RestResponseParseErrorMsgUtil;
import com.ibm.demo.fitnesse.vo.CustomerAccount;

import fit.ColumnFixture;

@Component
public class AccountOperationFixture extends ColumnFixture{
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private static final String BLANK = "";

	public String customerName;
	public String operation;
	public int amount;
		
	@Autowired
	private AccountOperationClientService accountOperationClientService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private RestResponseParseErrorMsgUtil restResponseParseErrorMsgUtil;
	private RestResponse restResponse;
	
	public AccountOperationFixture(){
        FixtureWirer.getInstance().wire(this);
	}
	
	@Override
	public void execute() throws Exception{
		try{
			log.info("AccountOperationFixture - customerName["+customerName+"], amount["+amount+"]");
			CustomerAccount customerAccount = new CustomerAccount();
			customerAccount.setCustomerName(customerName);
			customerAccount.setAmount(amount);

			accountOperationClientService.accountOperationClient(operation, customerAccount);
			
			log.info("AccountOperationFixture completed request");
		}catch(DemoFitnesseException e){
			restResponse = e.getRestResponse();
			log.error("Error occured in McpDeleteVmtaFixture",e);
			if(restResponse == null){
				throw e;
			}
		}		
	}	
	
	public int accountBalance() {
		return accountService.getBalanceByCustomerName(customerName);
	}
	
	public String message(){
		String message = restResponseParseErrorMsgUtil.getErrorMsgFromRestResponse(restResponse);
		if(message == null){
			return BLANK;
		}else{
			return message;
		}
		
	}
}
