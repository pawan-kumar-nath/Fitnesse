package com.ibm.demo.fitnesse.fixture;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.demo.fitnesse.config.FixtureWirer;
import com.ibm.demo.fitnesse.service.CustomerService;

import fitlibrary.SetUpFixture;


public class CustomerSetupFixture extends SetUpFixture {

    @Autowired
    private CustomerService customerService;

    public CustomerSetupFixture(){
        FixtureWirer.getInstance().wire(this);
    }

    public void createCustomerWithName(String customerName) {
        customerService.createCustomer(customerName);
    }

    public void deleteCustomerWithName(String customerName) {
        customerService.deleteCustomer(customerName);
    }
}
