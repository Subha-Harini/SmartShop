package com.cognizant.smartshop.signupservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.smartshop.signupservice.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUserId(String user);
	
	@Query(nativeQuery = true, value = "select * from user where us_status = 'P';")
	List<User> findAllByStatus();
	
	@Query(nativeQuery = true, value = "select * from user where us_contact_number = :number ;")
	User findByContactNumber(@Param("number") long number);

}
