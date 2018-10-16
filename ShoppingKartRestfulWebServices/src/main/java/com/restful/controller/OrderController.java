package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.Order;
import com.restful.serviceinterface.OrderRestfulServiceInterface;

@RestController
public class OrderController {
	
	@Autowired
	OrderRestfulServiceInterface orderRestfulServiceInterface;
	
	
	@PostMapping(value = "/createOrder", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Order createOrder(@RequestBody Order order){
		System.out.println("creating order");
				
		return  orderRestfulServiceInterface.createOrder(order);
		
	} 
	
	@GetMapping(value = "/getOrder/{orderId}",produces={"application/xml", "aplication/json"},headers = {"Accept=application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Order getCustomer(@PathVariable Integer orderId) throws Exception {
		System.out.println("finding for order ");
		return orderRestfulServiceInterface.findById(orderId);
	}
	
	@PutMapping(value="/updateorder",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Order updateOrders(@RequestBody Order order){
		return orderRestfulServiceInterface.updateOrder(order);
	}
	
	@DeleteMapping(value="/deleteorder/{orderId}")
	public void deleteOrder(@PathVariable int orderId){
		 orderRestfulServiceInterface.deleteOrder(orderId);
	}
	
		
}
