package com.demo.resuable.dataaccesslayer.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.demo.resuable.dataaccesslayer.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	Product findByName(String name);
	Product findByCode(int code);
	boolean existsByName(String name);
	boolean existsByCode(int code);
	List<Product> findAllByType(int type);
	void deleteByCode(int code);
	
	@Query(nativeQuery = true, value = "SELECT * FROM product WHERE pt_stock_count > 0;")
	List<Product> findAllProductAvailable();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_name ASC;")
	List<Product> getSortByName();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_rate_per_quantity ASC;")
	List<Product> getSortByPrice();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY pt_stock_count DESC;")
	List<Product> getSortByAvailability();
	
	@Query(nativeQuery = true, value = "select * from product INNER JOIN bill_Details ON (pt_code = product_pt_code) group by product_pt_code Order by sum(quantity) desc;")
	List<Product> getProductArray1();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product where pt_code not in (select pt_code from product INNER JOIN bill_Details ON (pt_code = product_pt_code) group by product_pt_code Order by sum(quantity) desc);")
	List<Product> getProductArray2();
	
	@Query(nativeQuery = true, value = "select * from product where pt_date_of_expiry < ?;")
	List<Product> getExpiredProducts(String date);
}
