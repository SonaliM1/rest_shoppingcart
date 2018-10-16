package com.restful.daointerface;

import com.restful.model.Order;

public interface OrderRestfulDaoInterface {

	Order createOrder(Order order);

	Order findById(Integer orderId);

	Order updateOrder(Order order);

	void deleteOrder(int orderId);

}
