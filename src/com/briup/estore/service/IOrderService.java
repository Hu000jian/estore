package com.briup.estore.service;

import java.util.Collection;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.Order;
import com.briup.estore.common.exception.OrderException;

public interface IOrderService {
	void confirmOrder(Customer customer,Order order,Collection<Line> lines) throws OrderException;
	void deleteOrder(Long id) throws OrderException;
	Order findById(Long id) throws OrderException;
}
