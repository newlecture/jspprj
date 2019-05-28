package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("°Ë»ö¾î>");
		String query = scan.nextLine();
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE ID LIKE '%"+query+"%'";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {

			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String name = rs.getString("NAME");
			
			System.out.printf("ID:%s, PWD:%s, NAME:%s\n", id, pwd, name);
		}	

		rs.close();
		st.close();
		con.close();

	}

}
