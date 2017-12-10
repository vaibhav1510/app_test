package com.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Customer;

@WebServlet(name = "/IndexCustomer", urlPatterns = "/index.jsp")
public class IndesCustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndesCustomerAction() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Customer> listCusts = Customer.getAll();			
			request.setAttribute("listCusts", listCusts);			
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}
}
