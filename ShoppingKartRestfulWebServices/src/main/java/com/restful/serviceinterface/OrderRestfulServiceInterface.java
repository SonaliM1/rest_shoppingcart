package com.restful.serviceinterface;

import com.restful.model.Order;

public interface OrderRestfulServiceInterface {

	Order createOrder(Order order);

	Order findById(Integer orderId);

	Order updateOrder(Order order);

	void deleteOrder(int orderId);

	

}
