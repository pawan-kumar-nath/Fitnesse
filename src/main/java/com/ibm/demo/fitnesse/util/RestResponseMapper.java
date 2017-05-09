package com.ibm.demo.fitnesse.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestResponseMapper {
	

	private JsonMapper jsonMapper;

	private final static String DEMO = "Fitnesse Demo";

	@Autowired
	private FeignUtil feignUtil;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public RestResponseMapper(final JsonMapper jsonMapper) {
		this.jsonMapper = jsonMapper;
	}

	public RestResponse convertStringToObject(String jsonStr) {
		return jsonMapper.convertStringToObject(jsonStr, RestResponse.class);
	}

	public RestResponse convertStringToObject(String jsonStr, String errorSource) {
		RestResponse restResponse = convertStringToObject(jsonStr);

		if (restResponse != null) {
			restResponse.getMeta().setErrorSource(errorSource);
		}

		return restResponse;
	}

	public RestResponse convertToObject(Throwable e) {
		RestResponse restResponse = null;
		try {
			String errorJson = feignUtil.getSourceExceptionMessage(e);

			if (errorJson != null) {
				restResponse = convertStringToObject(errorJson, DEMO);
			}
		} catch (Exception exp) {
			LOG.error("Error occurred while generating RestResponse from Error", exp);
		}

		return restResponse;
	}

	public String getErrorMessage(Throwable e, String source) {
		String errorMsg = StringUtils.EMPTY;
		StringBuilder returnMsg = new StringBuilder(StringUtils.EMPTY);
		try {
			RestResponse restResponse = convertToObject(e.getCause());
			errorMsg = restResponse.getMeta().getGeneralErrors().get(0);
			if (StringUtils.isNotEmpty(errorMsg)) {
				returnMsg.append("[").append(source).append("] ").append(errorMsg);
			}
		} catch (Exception exp) {
			LOG.error("Error occurred while fetching Error message from Rest Response", exp);
		}
		return returnMsg.toString();
	}
}
