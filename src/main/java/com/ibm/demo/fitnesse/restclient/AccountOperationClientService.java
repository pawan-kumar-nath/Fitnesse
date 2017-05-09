package com.ibm.demo.fitnesse.restclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.demo.fitnesse.config.FitnesseConfiguration;
import com.ibm.demo.fitnesse.exception.DemoFitnesseException;
import com.ibm.demo.fitnesse.util.FeignUtil;
import com.ibm.demo.fitnesse.util.RestResponse;
import com.ibm.demo.fitnesse.util.RestResponseMapper;
import com.ibm.demo.fitnesse.vo.CustomerAccount;

@Component
public class AccountOperationClientService {
	
	 private final Logger log = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private FeignUtil feignUtil;
		@Autowired
		private FitnesseConfiguration fitnesseConfiguration;
		@Autowired
		private RestResponseMapper restResponseMapper;
		
		public void accountOperationClient(String operation, CustomerAccount customerAccount){
			log.info("AccountDepositClientService - operation["+operation+"], customerAccount["+customerAccount+"]");

			AccountOperationClient client = feignUtil.getClient(AccountOperationClient.class, fitnesseConfiguration.getHostUrl());
			try{
				client.operation(operation, customerAccount);
			}catch(Exception e){
				log.error("Unable to do account operation",e);
				RestResponse restResponse = restResponseMapper.convertToObject(e);
				throw (new DemoFitnesseException(restResponse));
			}	
			
		}

}
