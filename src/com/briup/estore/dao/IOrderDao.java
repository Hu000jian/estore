package com.briup.estore.dao;


import com.briup.estore.bean.Order;

public interface IOrderDao  {
	public void saveOrder(Order order);
	public Order findOrderById(Long id);
	public void deleteOrder(Order order);
}
