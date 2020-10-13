package com.OnlineBuy_example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.OnlineBuy_example.demo.model.Orderdata;


public interface OrderRepo extends JpaRepository<Orderdata, Integer>{

	
	@Query(value="Select customername,email,mobile from Customer_Data where customer_Id  = ANY (Select customer_Id from OrderData where  order_Id in (Select order_Id from Order_Items where product_Id =?))",nativeQuery = true)
	List<String> particularprod(Integer id);
}
