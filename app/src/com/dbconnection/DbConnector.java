package com.dbconnection;

import java.sql.*;

public class DbConnector {
    private static Connection con;

    public static Connection open() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_db", "root", "");
        } catch (SQLException sqlExp) {
            sqlExp.printStackTrace();
        }
        return con;
    }

    public static void close() {
        try {
            con.close();
        } catch (SQLException sqlExp) {
            sqlExp.printStackTrace();
        }
    }

}
