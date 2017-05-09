package com.ibm.demo.fitnesse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FitnesseConfigurationImpl extends BaseConfiguration implements FitnesseConfiguration{

	private final String hostUrl;
	private final String dbUrl;
	private final String dbUser;
	private final String dbPassword;
	
	@Autowired
	public FitnesseConfigurationImpl(@Value("${hostUrl}") String hostUrl,
								@Value("${dbUrl}") String dbUrl,
								@Value("${dbUser}") String dbUser,
								@Value("${dbPassword}") String dbPassword
	){
		this.hostUrl = hostUrl;
		this.dbUrl = dbUrl;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	
		setEnvProperties(this);
	}

	public String getHostUrl() {
		return hostUrl;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

}
