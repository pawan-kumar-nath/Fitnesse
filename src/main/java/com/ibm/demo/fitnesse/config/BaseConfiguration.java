package com.ibm.demo.fitnesse.config;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import com.ibm.demo.fitnesse.exception.DemoFitnesseException;

public class BaseConfiguration {
	
	public static final String SYS_PROP_START_WITH = "{";
	public static final String SYS_PROP_END_WITH = "}";
	
	public String getSysPropValue(String propValue){
		if(propValue != null ){
			String sysPropKey = StringUtils.substringBetween(propValue, SYS_PROP_START_WITH, SYS_PROP_END_WITH);
			if(sysPropKey != null){
					String sysPropValue =  System.getenv(sysPropKey);
					if(sysPropValue == null){
						throw new DemoFitnesseException("System Property ["+sysPropValue+"] is not defined");
					}
					propValue = StringUtils.replace(propValue, SYS_PROP_START_WITH+sysPropKey+SYS_PROP_END_WITH, sysPropValue);
			}
		}
		
		return propValue;
	}
	
	
	public void setEnvProperties(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		
		for(Field field : fields){
			field.setAccessible(true);
			
			if(field.getType() != java.lang.String.class){
				continue;
			}
			
			try {
				field.set(obj, getSysPropValue( (String)field.get(obj) ));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new DemoFitnesseException("Error occured while setting enviornment variable");
			}

		}
		
	}
}
