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

@WebServlet(name = "/AddCustomer", urlPatterns = "/add_customer")
public class AddCustomerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCustomerAction() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Customer c = new Customer().email(request.getParameter("email")).phone(request.getParameter("phone"))
					.name(request.getParameter("name"));

			Address addr = new Address().city(request.getParameter("city")).state(request.getParameter("state"))
					.country(request.getParameter("country")).pincode(request.getParameter("pincode"));

			c.initAddresses(Arrays.asList(addr));
			c.dbInsert();
			response.sendRedirect("view_customer?cust_id=" + c.getId());
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
