package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Line;
import com.briup.estore.bean.ShoppingCar;

public class AddOrderlineServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add");
		
		HttpSession session = req.getSession();
		
		long id = Long.parseLong(req.getParameter("productid"));
		
		ShoppingCar car = (ShoppingCar) session.getAttribute("shoppingCar");
		Customer cust = (Customer) session.getAttribute("Customer");
		Line line = new Line();
		
		
		if(car==null){
			car = new ShoppingCar();
		}
		
		//构造一个line对象
		ServletContext appl = req.getServletContext();
		List<Book> list = (List<Book>)appl.getAttribute("books");
		System.out.println("list-------"+list);
		Book book = null;
		
		for(Book b:list){
			if(b.getId()==id){
				book = b;
			}
		}
		line.setBook(book);
		//将line放入购物车中
		car.add(line);
		
		for(Long l:car.getLines().keySet()){
			System.out.println(car.getLines().get(l).getBook().getName());
		}
		
		session.setAttribute("shoppingCar", car);
		
		req.getRequestDispatcher("index.jsp").forward(req, arg1);
	}
}
