package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import sun.org.mozilla.javascript.internal.EcmaError;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.MyBatisSqlSessionFactory;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.dao.ICustomerDao;
import com.briup.estore.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	
	@Override
	public void register(Customer customer) throws CustomerException{
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		
		ICustomerDao dao = session.getMapper(ICustomerDao.class);
		
		Customer ct = dao.findByName(customer.getName());
		if(ct!=null){
			throw new CustomerException("用户名已存在");
		}
		
		dao.saveCustomer(customer);
		
		session.commit();
	}

	@Override
	public Customer login(String name, String password)
			throws CustomerException {
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		
		ICustomerDao dao = session.getMapper(ICustomerDao.class);
		
		Customer ct = dao.findByName(name);
		if(ct!=null){
			
			if(!ct.getPassword().equals(password)){
				
				throw new CustomerException("密码输入错误");
			}else{
				
				return ct;
			}
		}else{
			throw new CustomerException("用户名输入错误");
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

}
