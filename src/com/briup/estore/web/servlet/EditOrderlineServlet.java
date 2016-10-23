package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;

public class EditOrderlineServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(req.getParameter("num"));
		long id = Long.parseLong(req.getParameter("bookid"));
		
		HttpSession session = req.getSession();
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		
		Map<Long, Line> map = car.getLines();
		Line line = map.get(id);
		line.setNum(num);
		
		req.getRequestDispatcher("shopcar.jsp").forward(req, arg1);
	}
}
