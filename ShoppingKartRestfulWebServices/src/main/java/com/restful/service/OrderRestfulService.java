package com.restful.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dao.CustomerRestfulDao;
import com.restful.dao.ProductRestfulDao;
import com.restful.daointerface.OrderRestfulDaoInterface;
import com.restful.model.Order;
import com.restful.serviceinterface.OrderRestfulServiceInterface;
 

@Service
@Transactional
public class OrderRestfulService implements OrderRestfulServiceInterface{
	
	@Autowired
	OrderRestfulDaoInterface orderRestfulDaoInterface;
	
	@Autowired
	CustomerRestfulDao customerRestfulDao;
	
	@Autowired
	ProductRestfulDao productRestfulDao;

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRestfulDaoInterface.createOrder(order);
	}

	@Override
	public Order findById(Integer orderId) {
		// TODO Auto-generated method stub
		Order order = orderRestfulDaoInterface.findById(orderId);
		order.setCustomer(customerRestfulDao.findById(order.getCustomerId()));
		order.setProduct(productRestfulDao.findById(order.getProductId()));
		return order;
	} 

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRestfulDaoInterface.updateOrder(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		orderRestfulDaoInterface.deleteOrder(orderId);
	}
}
