package com.ibm.demo.fitnesse.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Component
public class FeignUtil {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private static String ERROR_STRING_DELIMITOR = "content:";

	public <T> T getClient(Class<T> clazz, String url) {
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
		        .target(clazz, url);
	}

    public <T> T getClient(Class<T> clazz, String url, ErrorDecoder errorDecoder) {
        return Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .errorDecoder(errorDecoder)
            .target(clazz, url);
    }

	public String getSourceExceptionMessage(Throwable throwable){
		String extractedMessage = null;

		try{
			if(throwable != null ){

				String srcExceptionMessage = throwable.getMessage();

				if( srcExceptionMessage != null && srcExceptionMessage.indexOf(ERROR_STRING_DELIMITOR) != -1) {

					extractedMessage = srcExceptionMessage.substring((srcExceptionMessage.indexOf(ERROR_STRING_DELIMITOR) + ERROR_STRING_DELIMITOR.length()),
															srcExceptionMessage.length());
				}
			}
		}catch(Exception e){
			log.error("Not able to parse source exception", e);
		}

		return extractedMessage;
	}

}
