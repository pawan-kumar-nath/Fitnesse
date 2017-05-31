package com.ibm.demo.fitnesse.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface AccountDao {
  
   @SqlQuery("SELECT NVL(SUM(A.BALANCE),0) BALANCE FROM DEMO_CUSTOMER C, DEMO_ACCOUNT A WHERE C.CUSTOMER_NAME = :customerName AND C.CUSTOMER_ID = A.CUSTOMER_ID")
   int getBalanceByCustomerName(@Bind("customerName") String customerName);
   
}
