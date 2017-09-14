package com.libertymutual.goforcode.invoicify.models;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class UserRoleModelTests {

	@Before
	public void setUp() {
	}
	
	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .build();
        tester.testBean(UserRole.class, configuration);
	}
	
}
