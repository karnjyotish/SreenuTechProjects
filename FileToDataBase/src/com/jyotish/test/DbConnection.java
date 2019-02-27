/**@CopyRight 2019 J Technologies All Rights are Reserved.
 * you should disclose the information outside,otherwise
 * terms and conditions will be apply.
 */
package com.jyotish.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jyotish.beans.Products;

/**
 * @author Jyotish kumar
 *
 * @Feb 27, 2019
 */
public class DbConnection {
	private static final String INPUT_QUERY = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?,?,?,?)";
	Connection con = null;
	PreparedStatement ps = null;
	int count = 0;
	
	public void myConection(Products pd) throws SQLException {
		try {
			// Class.forName("Oracle.jdbc.driver.OracleDriver");
			// Establishing the connection from database.
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123654");
			// creating Prepared Statement
			ps = con.prepareStatement(INPUT_QUERY);
			// setting the values to the query from getters method
			ps.setLong(1, Long.parseLong(pd.getCardNumber().trim()));
			ps.setInt(2, pd.getPid());
			ps.setString(3, pd.getName());
			ps.setString(4, pd.getDesc());
			ps.setString(5, pd.isStock());
			ps.setDouble(6, pd.getPrice());
			ps.setDate(7, new java.sql.Date(pd.getExpdate().getTime()));
			ps.setFloat(8, pd.getDiscount());
			// inserting the record to database
			count = ps.executeUpdate();
			if (count == 0) {
				System.out.println("Not saved");
			} else {
				System.out.println("saved");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		// finally block closing the resources
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
	}// myConnection()


}
