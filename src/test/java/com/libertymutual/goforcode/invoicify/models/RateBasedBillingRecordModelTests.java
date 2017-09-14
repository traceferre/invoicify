package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;

public class RateBasedBillingRecordModelTests {

	@Before
	public void setUp() {
	}
	
	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
        		.ignoreProperty("createdOn")
                .build();
        tester.testBean(FlatFeeBillingRecord.class, configuration);
	}
	
	@Test
	public void checking_get_total_returns_rate_times_quantity() {
		RateBasedBillingRecord record = new RateBasedBillingRecord();
		record.setRate(20.5);
		record.setQuantity(10.0);
		double someAmount = 0.0;
		
		someAmount = record.getTotal();
		
		assertThat(someAmount).isEqualTo(205);		
	}
	
}
