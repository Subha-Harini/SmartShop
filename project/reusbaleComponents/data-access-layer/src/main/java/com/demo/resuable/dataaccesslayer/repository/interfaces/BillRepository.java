package com.demo.resuable.dataaccesslayer.repository.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.resuable.dataaccesslayer.entities.Bill;


@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>  {
	
	@Query(nativeQuery = true, value = "SELECT * FROM bill WHERE b_id = :id ;")
    Optional<Bill> findByBillId(@Param("id") int id);
	
	@Query(nativeQuery = true, value = "select max(b_d_id) from bill_details;")
	int findMaximunBillDetailsId();
	
	@Query(nativeQuery = true, value = "select max(b_id) from bill;")
	int findMaximunBillId();
	
	@Query(nativeQuery = true, value = "SELECT * FROM bill WHERE user_us_id = :id ;")
	List<Bill> getUserBills(@Param("id") int id);
}
