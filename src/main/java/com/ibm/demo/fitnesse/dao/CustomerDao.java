package com.ibm.demo.fitnesse.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface CustomerDao {

   @SqlUpdate("INSERT INTO DEMO_CUSTOMER (CUSTOMER_ID, CUSTOMER_NAME) VALUES (DEMO_CUST_SEQ.NEXTVAL, :customerName)")
   int createCustomer(@Bind("customerName") String customerName);

   @SqlQuery("SELECT CUSTOMER_ID FROM DEMO_CUSTOMER WHERE TRIM(CUSTOMER_NAME) = TRIM(:customerName) ")
   int getCustomerId(@Bind("customerName") String customerName);

   @SqlUpdate("DELETE FROM DEMO_CUSTOMER WHERE TRIM(CUSTOMER_NAME) = TRIM(:customerName)")
   int deleteCustomer(@Bind("customerName") String customerName);
}
