package com.restful.daointerface;

import java.util.List;

import com.restful.model.Customer;

public interface CustomerRestfulDaoInterface {

	Customer addCustomer(Customer customer);

	Customer findById(Integer custId);

	void delete(Integer custId);

	Customer update(Customer customer);

	List<Customer> getAllCustomers();

	

	

}
