package com.ibm.demo.fitnesse.config;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FixtureWirer {

    private static FixtureWirer instance;
    private final AutowireCapableBeanFactory beanFactory;
    
    public static void initializeForTest(FixtureWirer instance) {
        FixtureWirer.instance = instance;
    }

	public static FixtureWirer getInstance() {
        if(instance == null) {
            instance = new FixtureWirer();
        }
        return instance;
    }
    
	@SuppressWarnings("resource")
	protected FixtureWirer() {
        this((new ClassPathXmlApplicationContext("classpath:applicationContext.xml")).getBeanFactory());
 	}
    

    public static void initialize(AutowireCapableBeanFactory beanFactory) {
        instance = new FixtureWirer(beanFactory);
    }

    private FixtureWirer(AutowireCapableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void wire(Object object) {
        beanFactory.autowireBeanProperties(object, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
    }
}

