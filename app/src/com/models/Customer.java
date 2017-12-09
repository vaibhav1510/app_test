package com.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.DbExecutor;

public class Customer {
	private Long id;
	private String name;
	private String phone;
	private String email;

	private List<Address> addresses;

	public Long getId() {
		return id;
	}

	public Customer id(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Customer name(String name) {
		this.name = name;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public Customer phone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Customer email(String email) {
		this.email = email;
		return this;
	}

	public Address getAddress() {
		return addresses.get(0);
	}

	public void initAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public static Customer getCustomer(Long id) throws Exception {
		String sql = "select * from customers where id='" + id + "'";
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);
		Customer cust = null;
		while (rs.next()) {
			cust = new Customer() //
					.id(rs.getLong("id")) //
					.name(rs.getString("name")) //
					.phone(rs.getString("phone")) //
					.email(rs.getString("email"));
		}
		exec.close(rs);
		Address.initAddresses(cust);
		return cust;
	}

	public static List<Customer> getAll() throws Exception {
		List<Customer> toRet = new ArrayList<>();
		String sql = "select * from customers";
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);

		while (rs.next()) {
			Customer cust = new Customer() //
					.id(rs.getLong("id")) //
					.name(rs.getString("name")) //
					.phone(rs.getString("phone")) //
					.email(rs.getString("email"));
			Address.initAddresses(cust);
			toRet.add(cust);
		}
		exec.close(rs);
		return toRet;
	}

	public static Customer getCustomer(String email) throws Exception {
		String sql = "select * from customers where email='" + email + "'";
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);
		Customer cust = null;
		while (rs.next()) {
			cust = new Customer() //
					.id(rs.getLong("id")) //
					.name(rs.getString("name")) //
					.phone(rs.getString("phone")) //
					.email(rs.getString("email"));
		}
		exec.close(rs);
		Address.initAddresses(cust);
		return cust;
	}

	public void dbInsert() throws Exception {
		DbExecutor exec = DbExecutor.init();
		String sql = new StringBuilder().append("insert into customers set ") //
				.append("email='").append(email).append("',") //
				.append("phone='").append(phone).append("',") //
				.append("name='").append(name).append("'") //
				.toString();
		exec.update(sql);
		this.id(getCustomer(email).getId());
		exec.close();
		for (Address a : addresses) {
			a.dbInsert(this);
		}

	}

	public void dbUpdate() throws Exception {
		String sql = new StringBuilder().append("update customers set ") //
				.append("email='").append(email).append("',") //
				.append("phone='").append(phone).append("',") //
				.append("name='").append(name).append("'") //
				.append(" where id=").append(id) //
				.toString();
		DbExecutor exec = DbExecutor.init();
		exec.update(sql);
		this.id(getCustomer(email).getId());
		exec.close();
		for (Address a : addresses) {
			a.dbUpdate();
		}
	}

}
