package com.demo.resuable.dataaccesslayer.repository.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.resuable.dataaccesslayer.entities.Offer;

@Repository
public interface OfferRepository  extends JpaRepository<Offer, Integer>  {
	
	@Query(nativeQuery = true, value = "SELECT * FROM offer WHERE of_date = :date ;")
	public List<Offer> findByOfferDate(@Param("date") Date date);
	
	@Query(nativeQuery = true, value = "SELECT of_pt_code FROM offer WHERE of_date = :date ;")
	public List<Integer> findOfferCodes(@Param("date") Date date);
	
	@Query(nativeQuery = true, value = "SELECT of_discount_percent FROM offer WHERE of_pt_code = :code AND of_date = :date ;")
	public float findDiscountByCode(@Param("code") int code, @Param("date") Date date);
	
	@Query(nativeQuery = true, value = "SELECT * FROM offer WHERE DATE(of_date) = :date AND of_pt_code = :id ;")
	Optional<Offer> getOffer(@Param("date") Date date, @Param("id") int id);
}
