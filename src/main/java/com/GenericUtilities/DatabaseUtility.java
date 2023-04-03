package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection con = null;

	public void connecToDb() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(Ipathconstants.DBURL, Ipathconstants.DBUSERNAME, Ipathconstants.DBPASSWORD);
	}

	public String executeQueryAndGetData(String query, String expdata,int coloumnIndex) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while (result.next()) {
			String data = result.getString(coloumnIndex);
			if (data.equalsIgnoreCase(expdata)) {
				flag = true;
				break;
			}
		}
		
			if (flag) {
				System.out.println("data is vrified");
				return expdata;
			}
			else
			{
				System.out.println("data is not updated");

		}
	
			return expdata;
	}
	
	public void closeDb() throws Throwable
	{
		con.close();
		System.out.println("database connection closed");
	}
}
