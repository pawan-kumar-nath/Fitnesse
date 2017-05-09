package com.ibm.demo.fitnesse.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@Component
public class JsonMapper {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final Gson gson = new Gson();
	private final JsonParser jsonParser = new JsonParser();

	public <T> T convertStringToObject(String jsonStr, Class<T> clazz) {
		T restResponse = null;

		try {
			boolean isValid = isValidJson(jsonStr);
			if(isValid) {
				restResponse = gson.fromJson(jsonStr, clazz);
			}
		} catch(Exception e) {
			log.error("Error Occured while converting given String ["+jsonStr+"] to json", e);
		}

		return restResponse;
	}

	public String convertObjectToString(Object obj) {
        return gson.toJson(obj);
    }

	public boolean isValidJson(String json) {
		boolean result = false;
		log.debug("JSON to be validated: ["+json+"]");
		try {
			jsonParser.parse(json);
			result = true;
		} catch(JsonSyntaxException mfe) {
			log.warn("JSON parsing failed due to error", mfe);
		}
        return result;
	}
}
