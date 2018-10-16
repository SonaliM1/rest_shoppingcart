package com.restful.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.restful.daointerface.OrderRestfulDaoInterface;
import com.restful.model.Order;
import com.restful.model.Product;

@Repository
public class OrderRestfulDao  implements OrderRestfulDaoInterface {

			@PersistenceContext
			EntityManager entityManager;

			@Override
			public Order createOrder(Order order) {
				// TODO Auto-generated method stub
				
				entityManager.persist(order);
				return order;
			}

			@Override
			public Order findById(Integer orderId) {
				// TODO Auto-generated method stub
				System.out.println("dao orderClass");
				return entityManager.find(Order.class, orderId);
			}

			@Override
			public Order updateOrder(Order order) {
				// TODO Auto-generated method stub
				entityManager.merge(order);
				return order;
			}
 
			@Override
			public void deleteOrder(int orderId) {
				// TODO Auto-generated method stub
				Order orderObj = findById(orderId);
				if(orderObj != null)
				{
					entityManager.remove(orderObj);
				}
			}
	 
}
