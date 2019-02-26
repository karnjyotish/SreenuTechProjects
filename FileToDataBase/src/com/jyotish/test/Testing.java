package com.jyotish.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Testing {
	private static final String INPUT_QUERY="INSERT INTO TEST11(ID) VALUES(?)";
	public static void main(String[] args)throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123654");
		if(con!=null) {
			System.out.println("Connected");
			
		}
		ps = con.prepareStatement(INPUT_QUERY);
		ps.setLong(1, 1244569871245968l);
		/*ps.setString(2, "JYOTISH");
		ps.setString(3, "Hatia");*/
	 count=	ps.executeUpdate();
		if(count==0)
		{
			System.out.println("Not saved");
		}
		else
		{
			System.out.println("Saved");
		}

	}

}
