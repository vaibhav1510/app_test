package com.dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbExecutor {

	private Connection conn;
	private Statement stmt;

	private DbExecutor() throws Exception {
		conn = DbConnector.open();
	}

	public static DbExecutor init() throws Exception {
		return new DbExecutor();
	}

	public void close(ResultSet rs) throws Exception {
		rs.close();
		close();
	}

	public void close() throws Exception {
		stmt.close();
		conn.close();

	}

	public int update(String sql) throws Exception {
		System.out.println("LOG >>> " + sql);
		stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		close();
		return count;
	}

	public ResultSet select(String sql) throws Exception {
		System.out.println("LOG >>> " + sql);
		stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}

}
