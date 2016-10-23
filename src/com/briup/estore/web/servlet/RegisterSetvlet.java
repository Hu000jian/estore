package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class RegisterSetvlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8947584896676875066L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("userid");
		String password = req.getParameter("password");
		String country = req.getParameter("country");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String street1 = req.getParameter("street1");
		//String street2 = req.getParameter("street2");
		String zip = req.getParameter("zip");
		//String homephone = req.getParameter("homephone");
		//String officephone = req.getParameter("officephone");
		String cellphone = req.getParameter("cellphone");
		String email = req.getParameter("email");
		
		String address=country+province+city+street1;
		Customer cust = new Customer(name,password,zip,address,cellphone,email);
		
		CustomerServiceImpl csi = new CustomerServiceImpl();
		
		try {
			csi.register(cust);
			req.getRequestDispatcher("login.action").forward(req,resp);
		} catch (CustomerException e) {
			req.setAttribute("msg", "用户名已存在");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			
		}
		
	}
}
