package com.actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Customer;

@WebServlet(name = "/SearchCustomer", urlPatterns = "/search_customer")
public class SearchCustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchCustomerAction() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {			
			Customer cust = Customer.getCustomer(request.getParameter("search_email"));
			request.setAttribute("cust", cust);
			request.getRequestDispatcher("customer/view.jsp").forward(request, response);
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
