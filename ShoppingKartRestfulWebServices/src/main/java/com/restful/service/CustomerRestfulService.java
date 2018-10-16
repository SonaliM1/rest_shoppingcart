package com.restful.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.daointerface.CustomerRestfulDaoInterface;
import com.restful.model.Customer;
import com.restful.serviceinterface.CustomerRestfulServiceInterface;
 
@Service
@Transactional
public class CustomerRestfulService implements CustomerRestfulServiceInterface{

	@Autowired
	private CustomerRestfulDaoInterface customerrestfulDaoInterface;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("service class");
		return customerrestfulDaoInterface.addCustomer(customer);
	}
 
	@Override
	public Customer findById(Integer custId) {
		// TODO Auto-generated method stub
		return customerrestfulDaoInterface.findById(custId);
	}
 
	@Override
	public void delete(Integer custId) {
		// TODO Auto-generated method stub
		customerrestfulDaoInterface.delete(custId);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return customerrestfulDaoInterface.update(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerrestfulDaoInterface.getAllCustomers();
	}

}
