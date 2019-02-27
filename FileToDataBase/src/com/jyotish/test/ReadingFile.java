/**@CopyRight 2019 J Technologies All Rights are Reserved.
 * you should disclose the information outside,otherwise
 * terms and conditions will be apply.
 */
package com.jyotish.test;
/**
 * @author Jyotish Kumar
 *
 * @Feb 27, 2019
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.jyotish.beans.Products;

public  class ReadingFile {
	
	static int total_records = 0;
	static int invalid_records = 0;
	static int valid_records = 0;
	public  void readFile() throws Exception {
		// bean class
		Products pd = new Products();
		// main class object
		DbConnection connect=new DbConnection();
		// file location
		File file = new File("C:\\Users\\Jyotish\\git\\repository\\FileToDataBase\\src\\files\\custInfo.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		// reading the file
		while ((str = reader.readLine()) != null) {
			try {
				System.out.println(str);
				total_records++;
				// spliting the record with ~
				String[] temp = str.split("~");
				String cardNumber = temp[0];
				int pid = Integer.parseInt(temp[1].trim());
				String name = temp[2].trim();
				String desc = temp[3].trim();
				String isStock = temp[4].trim();
				double price = Double.parseDouble(temp[5].trim());
				Date expdate = new SimpleDateFormat("dd-MM-yyyy").parse(temp[6].trim());
				float discount = Float.parseFloat(temp[7].trim());
				// setting values to setters methods
				pd.setCardNumber(cardNumber);
				pd.setPid(pid);
				pd.setName(name);
				pd.setDesc(desc);
				pd.setStock(isStock);
				pd.setPrice(price);
				pd.setExpdate(expdate);
				pd.setDiscount(discount);
				// calling connection class method.
				connect.myConection(pd);
			} catch (Exception e) {
				invalid_records++;
			}
		}
		// printing the valid and invalid records
		System.out.println("Total records = " + total_records);
		System.out.println("Total Invalid records = " + invalid_records);
		System.out.println("Total valid Records = " + (total_records - invalid_records));
	}
	}// class
