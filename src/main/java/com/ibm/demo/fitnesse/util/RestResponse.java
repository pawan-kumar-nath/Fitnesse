package com.ibm.demo.fitnesse.util;

import org.apache.commons.lang3.ObjectUtils;

public class RestResponse {

    private ResponseMetadata meta = new ResponseMetadata();
    
    private Object data;

    public RestResponse() {
    }

    public RestResponse(Object data) {
        this.data = data;
    }

    public RestResponse(String errorMessage) {
        this.meta.addGeneralError(errorMessage);
    }

    public void addGeneralError(String errorMessage) {
        meta.addGeneralError(errorMessage);
    }

    public void addFieldError(String field, String errorMessage) {
        meta.addFieldError(field, errorMessage);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseMetadata getMeta() {
        return meta;
    }

    public void setMeta(ResponseMetadata meta) {
        this.meta = meta;
    }
    
   
    @SuppressWarnings("deprecation")
	@Override
    public int hashCode() {
        return 17 + ObjectUtils.hashCode(data) + ObjectUtils.hashCode(meta);
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public boolean equals(Object object) {
        if (object instanceof RestResponse) {
            RestResponse that = (RestResponse) object;
            return ObjectUtils.equals(this.data, that.data) &&
                   ObjectUtils.equals(this.meta, that.meta);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "RestResponse: [" +
        		"data: " + data + ", " +
                "meta: " + meta +
        		"]";
    }
    
}
