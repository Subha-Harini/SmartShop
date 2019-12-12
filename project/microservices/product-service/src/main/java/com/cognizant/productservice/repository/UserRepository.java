package com.cognizant.productservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.productservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where us_user_id=:userId ;")
	User findByUserId(@Param("userId") String userId);
	
	boolean existsByUserId(String userId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where us_user_type='U';")
	List<User> findAllByUserType();
}
