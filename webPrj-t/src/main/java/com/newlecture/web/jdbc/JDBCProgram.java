package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String query = "%' AND (";
		String sql = String.format("select * from member where nicname like '%%' AND %'", "%"+query+"%") ;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		// 필터링, 집계, 정렬
		while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
		{
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String nicName = rs.getString("nicname");
			String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
			System.out.println(format);
		}
		
		con.close();
				
		
		
		
//		DriverManager
//		Connection
//		Statement
//		Resultset
	}

}
