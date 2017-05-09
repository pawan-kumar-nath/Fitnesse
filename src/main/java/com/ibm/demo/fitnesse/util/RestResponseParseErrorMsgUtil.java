package com.ibm.demo.fitnesse.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RestResponseParseErrorMsgUtil {
	
	public String getErrorMsgFromRestResponse(RestResponse restResponse){
		String errMsg = null;
		if(restResponse != null){
			ResponseMetadata responseMetadata = restResponse.getMeta();
			if( responseMetadata != null ){
				List<String> errorsList = responseMetadata.getGeneralErrors();
				if(errorsList != null && errorsList.size() > 0){
					errMsg = errorsList.get(0);
				}
			}
		}
		
		return errMsg;
		
	}
	
}
