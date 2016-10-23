package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.ShoppingCar;

public class DeleteOrderlineServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long id = Long.parseLong(req.getParameter("productid"));
		System.out.println(id);
		
		HttpSession session = req.getSession();
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		
		car.delete(id);
		
		req.getRequestDispatcher("shopcar.jsp").forward(req, arg1);
	}
}
