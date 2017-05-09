package com.ibm.demo.fitnesse.restclient;

import com.ibm.demo.fitnesse.vo.CustomerAccount;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface AccountOperationClient {

	@Headers("Content-Type: application/json")
	@RequestLine("POST /fitnesse/demo/account/?operation={operation}")
	public void operation(@Param("operation") String operation, CustomerAccount customerAccount);
}
