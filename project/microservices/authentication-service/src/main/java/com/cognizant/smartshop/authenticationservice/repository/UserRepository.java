package com.cognizant.smartshop.authenticationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.authenticationservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserId(String user);

}
