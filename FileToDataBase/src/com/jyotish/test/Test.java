package com.jyotish.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jyotish.beans.Products;

public class Test {
	private static final String INPUT_QUERY = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?,?,?,?)";
	Connection con = null;
	PreparedStatement ps = null;
	int count = 0;
	static int total_records = 0;
	static int invalid_records = 0;
	static int valid_records = 0;

	public static void main(String[] args) throws Exception {

		// bean class
		Products pd = new Products();
		
		//main class object
		Test test = new Test();

		// file location
		File file = new File("C:\\Users\\Jyotish\\CoreJava\\FileToDataBase\\src\\files\\custInfo.txt");

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;

		// for storing the values from file
		String cardNumber;
		int pid;
		String name;
		String desc;
		String isStock;
		double price;
		Date expdate;
		float discount;
		// reading the file

		while ((str = reader.readLine()) != null) {
			try {
				System.out.println(str);
				total_records++;

				// spliting the record with ~
				String[] temp = str.split("~");

				cardNumber = temp[0];
				pid = Integer.parseInt(temp[1].trim());
				name = temp[2].trim();
				desc = temp[3].trim();
				isStock = temp[4].trim();
				price = Double.parseDouble(temp[5].trim());
				expdate = new SimpleDateFormat("dd-MM-yyyy").parse(temp[6].trim());
				discount = Float.parseFloat(temp[7].trim());

				// setting values to setters methods

				pd.setCardNumber(cardNumber);
				pd.setPid(pid);
				pd.setName(name);
				pd.setDesc(desc);
				pd.setStock(isStock);
				pd.setPrice(price);
				pd.setExpdate(expdate);
				pd.setDiscount(discount);

				// calling connection method.

				test.myConection(pd);
			} catch (Exception e) {
				invalid_records++;
			}

		}
		// printing the valid and invalid records
		System.out.println("Total records = " + total_records);
		System.out.println("Total Invalid records = " + invalid_records);
		System.out.println("Total valid Records = " + (total_records - invalid_records));

	}
	
	
	
	
	
	
	

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
}// class
