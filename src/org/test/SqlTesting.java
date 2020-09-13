package org.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlTesting {
public static void main(String[] args) {
	
	Connection co=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	 co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","5254");
		
		String sql="select * from studentdetails";
		
		PreparedStatement pre = co.prepareStatement(sql);
		ResultSet ex = pre.executeQuery();
		while(ex.next()) {
			int sid = ex.getInt("studentid");
			String fname = ex.getString("firstname");
			String lname = ex.getString("lastname");
			long mobile = ex.getLong("phone");
			String gen = ex.getString("gender");
			String date = ex.getString("dob");
			String ads = ex.getString("address");
			String pin = ex.getString("pincode");
			String lan = ex.getString("languages");
			String pass = ex.getString("password");
			System.out.println(sid);
			System.out.println(fname);
			System.out.println(lname);
			System.out.println(mobile);
			System.out.println(gen);
			System.out.println(date);
			System.out.println(ads);
			System.out.println(pin);
			System.out.println(lan);
			System.out.println(pass);
		}
		

		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}finally {
		try {
			co.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
}
