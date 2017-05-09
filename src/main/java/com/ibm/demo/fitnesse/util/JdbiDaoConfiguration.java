package com.ibm.demo.fitnesse.util;

import java.sql.SQLException;

import org.skife.jdbi.v2.DBI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.demo.fitnesse.config.FitnesseConfiguration;

import oracle.jdbc.pool.OracleDataSource;

@Component
public class JdbiDaoConfiguration {
	
	@Autowired
	private FitnesseConfiguration fitnesseConfiguration;
	
	private DBI dbi;
		
	private DBI getJdbiSession() throws SQLException{
		
		if(dbi == null){
			
			OracleDataSource oracleDatasource = new OracleDataSource();
		    oracleDatasource.setURL(fitnesseConfiguration.getDbUrl());
		    oracleDatasource.setUser(fitnesseConfiguration.getDbUser());
		    oracleDatasource.setPassword(fitnesseConfiguration.getDbPassword());
			
		    dbi = new DBI(oracleDatasource); 
		}
		
	    return dbi;
	} 
	
	public <T> T getDao(Class<T> clazz) throws SQLException {
		DBI jdbi = getJdbiSession();
		return jdbi.onDemand(clazz);
	}
}
