package com.ibm.demo.fitnesse.exception;

import com.ibm.demo.fitnesse.util.RestResponse;

@SuppressWarnings("serial")
public class DemoFitnesseException extends RuntimeException {
	
	private RestResponse restResponse;
	
    public DemoFitnesseException() {
    }

    public DemoFitnesseException(String message) {
        super(message);
    }
    
    public DemoFitnesseException(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
    
    public DemoFitnesseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoFitnesseException(Throwable cause) {
        super(cause);
    }

    public DemoFitnesseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
	public RestResponse getRestResponse() {
		return restResponse;
	}
}