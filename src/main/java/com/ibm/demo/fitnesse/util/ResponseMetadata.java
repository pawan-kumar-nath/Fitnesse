package com.ibm.demo.fitnesse.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMetadata {

    private Map<String, String> attributes;
    private List<String> generalErrors;
    private Map<String, String> fieldErrors;
    private String errorSource;

    public ResponseMetadata() {
        this(new HashMap<String,String>(),
             new ArrayList<String>(),
             new HashMap<String,String>());
    }
        
	public ResponseMetadata(Map<String, String> attributes,
                            List<String> generalErrors,
                            Map<String, String> fieldErrors) {
        this.attributes = attributes;
        this.generalErrors = generalErrors;
        this.fieldErrors = fieldErrors;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public List<String> getGeneralErrors() {
        return generalErrors;
    }

    public void setGeneralErrors(List<String> generalErrors) {
        this.generalErrors = generalErrors;
    }

    public void addGeneralError(String errorMessage) {
        this.generalErrors.add(errorMessage);
    }

    public Map<String,String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String,String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public void addFieldError(String field, String errorMessage) {
        this.fieldErrors.put(field,errorMessage);
    }

    public String getErrorSource() {
		return errorSource;
	}

	public void setErrorSource(String errorSource) {
		this.errorSource = errorSource;
	}   
        
    @Override
    public String toString() {
        return "ResponseMetadata(" + attributes + ", " + generalErrors + ", " + fieldErrors + ')';
    }

}