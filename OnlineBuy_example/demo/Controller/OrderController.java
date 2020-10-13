package com.OnlineBuy_example.demo.Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineBuy_example.demo.Repository.CustomerRepo;
import com.OnlineBuy_example.demo.Repository.OrderItemsRepository;
import com.OnlineBuy_example.demo.Repository.OrderRepo;
import com.OnlineBuy_example.demo.Repository.ProductRep;
import com.OnlineBuy_example.demo.model.CustomerData;
import com.OnlineBuy_example.demo.model.OrderItems;
import com.OnlineBuy_example.demo.model.Orderdata;
import com.OnlineBuy_example.demo.model.ProductData;


@RestController
public class OrderController {
	

	@Autowired
	private OrderRepo orderRepository;
	
	@Autowired
	private ProductRep product;
	
	@Autowired
	private CustomerRepo customer;
	@Autowired
	private OrderItemsRepository orderItemRep;

	@PostMapping(value="/save")
	public String insertData(@RequestBody Orderdata orderdata) {
		Orderdata ord=orderRepository.save(orderdata);
		Set<OrderItems>itemList=orderdata.getOrderItems();
		itemList.forEach(item->{item.getPrimaryKey().setOrders(ord);orderItemRep.save(item);});
         System.out.println(ord.getOrderId());
         
		itemList.forEach(item->System.out.println(item.getPrimaryKey().getOrders()));
		return "Orders Placed";
	}
	
	
	@GetMapping(value="/Customers_Who_did_not_buy")
	public List<CustomerData> getvalues(){
		List<CustomerData> doesntBuy = customer.findallcustomerid();
		
		return doesntBuy;
	}
	
	
	@GetMapping(value="/particularproduct/{id}")
	public List<String> particularprod(@PathVariable Integer id){
		return orderRepository.particularprod(id);
	}
	
	
	@GetMapping(value="/notsoldproduct")
	public List<ProductData> notsoldproduct(){
		List<ProductData> notSold = product.findallproductid();
		return notSold;
		
	}
	
}

