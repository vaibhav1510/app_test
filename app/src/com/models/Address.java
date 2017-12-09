package com.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dbconnection.DbExecutor;

public class Address {

	private Long id;
	private String city;
	private String state;
	private String country;
	private String pincode;

	public Long getId() {
		return id;
	}

	public Address id(Long id) {
		this.id = id;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address city(String city) {
		this.city = city;
		return this;
	}

	public String getState() {
		return state;
	}

	public Address state(String state) {
		this.state = state;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address country(String country) {
		this.country = country;
		return this;
	}

	public String getPincode() {
		return pincode;
	}

	public Address pincode(String pincode) {
		this.pincode = pincode;
		return this;
	}

	public static Boolean initAddresses(Customer cust) throws Exception {
		List<Address> toRet = new ArrayList<Address>();
		String sql = "select * from addresses where customer_id=" + cust.getId();
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);

		while (rs.next()) {
			Address uw = new Address().id(rs.getLong("id")) //
					.city(rs.getString("city")) //
					.state(rs.getString("state")) //
					.country(rs.getString("country")) //
					.pincode(rs.getString("pincode"));
			toRet.add(uw);
		}
		cust.initAddresses(toRet);
		exec.close();
		return true;
	}

	public void dbInsert(Customer cust) throws Exception {
		String sql = new StringBuilder().append("insert into addresses set ") //
				.append("customer_id='").append(cust.getId()).append("',") //
				.append("city='").append(city).append("',") //
				.append("state='").append(state).append("',") //
				.append("country='").append(country).append("',") //
				.append("pincode='").append(pincode).append("'") //
				.toString();
		DbExecutor exec = DbExecutor.init();
		exec.update(sql);
		initAddresses(cust);
	}

	public void dbUpdate() throws Exception {
		String sql = new StringBuilder().append("update addresses set ") //
				.append("city='").append(city).append("',") //
				.append("state='").append(state).append("',") //
				.append("country='").append(country).append("',") //
				.append("pincode='").append(pincode).append("'") //
				.append(" where id=").append(id).toString();
		DbExecutor exec = DbExecutor.init();
		exec.update(sql);
	}

}
