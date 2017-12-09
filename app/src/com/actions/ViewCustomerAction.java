package com.actions;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Address;
import com.models.Customer;

@WebServlet(name = "/ViewCustomer", urlPatterns = "/view_customer")
public class ViewCustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCustomerAction() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Customer cust = Customer.getCustomer(Long.parseLong(request.getParameter("cust_id")));
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
