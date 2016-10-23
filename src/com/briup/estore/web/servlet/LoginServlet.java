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
import com.briup.estore.common.exception.BookException;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse arg1)
			throws ServletException, IOException {
		BookServiceImpl bsi = new BookServiceImpl();
		CustomerServiceImpl csi = new CustomerServiceImpl();
		
		String name = req.getParameter("userid");
		String password = req.getParameter("password");
		
		ServletContext application = req.getServletContext();
		
//		Book b1 = new Book(1l,"精通Hibernate：Java对象持久化技术详解",59.00);
//		Book b2 = new Book(2l,"Effective Java中文版",39.00);
//		Book b3 = new Book(3l,"Java 2核心技术（第6版） 卷I：基础知识 ",75.00);
//		Book b4 = new Book(4l,"深入浅出Hibernate",59.00);
//		Book b5 = new Book(5l,"JAVA编程思想：第3版",95.00);
		List<Book> list = null;
		try {
			list = bsi.listAllBooks();
			application.setAttribute("books", list);
		} catch (BookException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Customer customer = csi.login(name, password);
			req.getRequestDispatcher("index.jsp").forward(req, arg1);
			
			HttpSession session = req.getSession();
			session.setAttribute("customer", customer);
		} catch (CustomerException e) {
			req.getRequestDispatcher("login.jsp").forward(req, arg1);
			
		}
	}
}
