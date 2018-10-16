package com.restful.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.restful.daointerface.CustomerRestfulDaoInterface;
import com.restful.model.Customer;



@Repository
public class CustomerRestfulDao implements CustomerRestfulDaoInterface {

		
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("in Dao ");
		entityManager.persist(customer); 
		return customer;
	}

	@Override
	public Customer findById(Integer custId) {
		// TODO Auto-generated method stub
		return entityManager.find(Customer.class, custId);
	}

	@Override
	public void delete(Integer custId) {
		// TODO Auto-generated method stub
		Customer customer = findById(custId);
		if(customer != null){
			System.out.println("deleting");
			entityManager.remove(customer);
			System.out.println("deleted//....");
		}
			
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer customerobj = findById(customer.getCustomerId());
		
		/* Customer newCustomer = entityManager.find(Customer.class, customer.getCustomerId());
		 newCustomer.setCustomerName(customer.getCustomerName());
		 entityManager.persist(newCustomer);
		 entityManager.merge(newCustomer);*/
		if(customerobj !=null){ 
			
			Query query = entityManager.createQuery("update Customer set customerName = '" +customer.getCustomerName()+ "' ,customerContactNumber = '"+customer.getCustomerContactNumber()+"' , customerAddress = '"+customer.getCustomerAddress()+"' where customerId ='"+customer.getCustomerId()+"'  ");
			query.executeUpdate();
		}
		 
		return customer;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		List<Customer> customerList = entityManager.createQuery("From Customer",Customer.class).getResultList();
		return customerList;
	}

}
