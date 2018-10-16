package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restful.model.Customer;
import com.restful.serviceinterface.CustomerRestfulServiceInterface;



@RestController
public class CustomerController {
	
	@Autowired 
	private CustomerRestfulServiceInterface customerRestfulServiceInterface;

	@PostMapping(value = "/customers", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer){
		System.out.println("adding customer");
		return  customerRestfulServiceInterface.addCustomer(customer);
		
	} 
	
	@GetMapping(value = "/customers/{custId}",produces={"application/xml", "aplication/json"},headers = {"Accept=application/json"})
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Customer getCustomer(@PathVariable Integer custId) throws Exception {
		System.out.println("finding customer by id ");
		return customerRestfulServiceInterface.findById(custId);
	}
	
	@DeleteMapping(value = "/customers/{custId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("custId") Integer custId) throws Exception {
		customerRestfulServiceInterface.delete(custId);
	}
	
	@PutMapping(value= "/updatecustomers")
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) throws Exception{
		 return customerRestfulServiceInterface.update(customer);
	}
	
	@GetMapping(value="/findallCustomers")
	public @ResponseBody List<Customer> getAllCustomers(){
		System.out.println("find all customers..");
		return customerRestfulServiceInterface.getAllCustomers();
		
	}
	
}
