package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.Configuration;
import org.meanbean.test.ConfigurationBuilder;
import org.springframework.security.core.GrantedAuthority;

public class UserModelTests {
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
	}
	
	@Test
    public void checking_to_make_sure_my_getters_and_setters_work() {
        BeanTester tester = new BeanTester();
        Configuration configuration = new ConfigurationBuilder()
                .build();
        tester.testBean(User.class, configuration);
	}
	
	@Test
	public void testing_isAccountNonExpired_returns_true() {
		boolean letsSee = false;
		
		letsSee = user.isAccountNonExpired();
		
		assertThat(letsSee).isEqualTo(true);
	}
	
	@Test
	public void testing_isAccountNonLocked_returns_true() {
		boolean letsSee = false;
		
		letsSee = user.isAccountNonLocked();
		
		assertThat(letsSee).isEqualTo(true);
	}
	
	@Test
	public void testing_isCredentialsNonExpired_returns_true() {
		boolean letsSee = false;
		
		letsSee = user.isCredentialsNonExpired();
		
		assertThat(letsSee).isEqualTo(true);
	}
	
	@Test
	public void testing_isEnabled_returns_true() {
		boolean letsSee = false;
		
		letsSee = user.isEnabled();
		
		assertThat(letsSee).isEqualTo(true);
	}
	
	@Test
	public void testing_getAuthorities_returns_collection_of_authority_strings() {
		List<UserRole> roleNames = new ArrayList<UserRole>();
		UserRole role = new UserRole();
		role.setName("ONE");
		roleNames.add(role);
		UserRole roleTwo = new UserRole();
		roleTwo.setName("TWO");
		roleNames.add(roleTwo);
		user.setUserRoles(roleNames);
		
		Collection<? extends GrantedAuthority> actual = user.getAuthorities();
		
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual.toString()).isEqualTo("[ROLE_ONE, ROLE_TWO]");
	}
	
}
