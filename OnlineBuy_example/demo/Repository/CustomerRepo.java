package com.OnlineBuy_example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OnlineBuy_example.demo.model.CustomerData;



public interface CustomerRepo extends JpaRepository<CustomerData, Integer>{
	
	@Query(value = "Select * from Customer_Data where customer_Id not in(select customer_Id from OrderData)",nativeQuery = true)
	List<CustomerData> findallcustomerid();

}
