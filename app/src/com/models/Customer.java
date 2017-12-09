package com.models;

import java.sql.ResultSet;
import java.util.List;

import com.dbconnection.DbExecutor;

public class Customer {
	private Long id;
	private String name;
	private String phone;
	private String email;

	private List<Address> addresses;
	
	
	public Long id() {
		return id;
	}

	public Customer id(Long id) {
		this.id = id;
		return this;
	}

	public String name() {
		return name;
	}

	public Customer name(String name) {
		this.name = name;
		return this;
	}

	public String phone() {
		return phone;
	}

	public Customer phone(String phone) {
		this.phone = phone;
		return this;
	}

	public String email() {
		return email;
	}

	public Customer email(String email) {
		this.email = email;
		return this;
	}
	
	public List<Address> addresses() {		
		return addresses;
	}

	public void initAddresses(List<Address> addresses) {
		this.addresses = addresses;		
	}


	public static Customer getUser(String email) throws Exception {
		String sql = "select * from users where email='" + email + "'";
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);
		Customer c = new Customer().id(rs.getLong("id")).name(rs.getString("name")).phone(rs.getString("phone"))
				.email(rs.getString("email"));
		exec.close(rs);
		return c;
	}

}
