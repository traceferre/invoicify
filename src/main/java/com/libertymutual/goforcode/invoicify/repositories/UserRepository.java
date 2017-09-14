package com.libertymutual.goforcode.invoicify.repositories;

import org.springframework.stereotype.Repository;
import com.libertymutual.goforcode.invoicify.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
