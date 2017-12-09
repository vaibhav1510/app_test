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

	public Long id() {
		return id;
	}

	public Address id(Long id) {
		this.id = id;
		return this;
	}

	public String city() {
		return city;
	}

	public Address city(String city) {
		this.city = city;
		return this;
	}

	public String state() {
		return state;
	}

	public Address state(String state) {
		this.state = state;
		return this;
	}

	public String country() {
		return country;
	}

	public Address country(String country) {
		this.country = country;
		return this;
	}

	public String pincode() {
		return pincode;
	}

	public Address pincode(String pincode) {
		this.pincode = pincode;
		return this;
	}

	public static Boolean initAddresses(Customer u) throws Exception {
		List<Address> toRet = new ArrayList<Address>();
		String sql = "select * from addresses where customer_id=" + u.id();
		DbExecutor exec = DbExecutor.init();
		ResultSet rs = exec.select(sql);

		Address uw = new Address().id(rs.getLong("id")).city(rs.getString("city")).state(rs.getString("state"))
				.country(rs.getString("country")).pincode(rs.getString("pincode"));
		toRet.add(uw);
		u.initAddresses(toRet);
		exec.close();
		return true;
	}

	public void dbInsert() throws Exception {
		String sql = new StringBuilder().append("insert into addresses set ").append("city='").append(city).append("',")
				.append("state='").append(state).append("',").append("country='").append(country).append("',")
				.append("pincode='").append(pincode).append("'").toString();
		DbExecutor exec = DbExecutor.init();
		exec.update(sql);
	}

	public void dbUpdate() throws Exception {
		String sql = new StringBuilder().append("update addresses set ").append("city='").append(city).append("',")
				.append("state='").append(state).append("',").append("country='").append(country).append("',")
				.append("pincode='").append(pincode).append("'").append(" where id=").append(id).toString();
		DbExecutor exec = DbExecutor.init();
		exec.update(sql);
	}

}
