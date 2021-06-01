package com.demo.resuable.dataaccesslayer.repository.interfaces;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.resuable.dataaccesslayer.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//User findByUserId(String user);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where us_user_id=:userId ;")
	User findByUserId(@Param("userId") String userId);
	
	boolean existsByUserId(String userId);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user where us_user_type='U';")
	List<User> findAllByUserType();
	
	@Query(nativeQuery = true, value = "select * from user where us_status = 'P';")
	List<User> findAllByStatus();
	
	@Query(nativeQuery = true, value = "select * from user where us_contact_number = :number ;")
	User findByContactNumber(@Param("number") long number);

}
