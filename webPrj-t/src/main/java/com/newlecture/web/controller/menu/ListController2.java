package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu/list2")
public class ListController2 extends HttpServlet{
	
	private MenuService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//GList<Menu> menus = new GList<>();
		List<Menu> menus = new ArrayList<>();
		
		//resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("hello");
		
		String query = "";
		String sql = String.format("select * from member where nicname like '%s'", "%"+query+"%") ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			//Menu[] menus = new Menu[100];
			
			//List<Menu> list = new ArrayList<>();
			
			
			
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nicName = rs.getString("nicname");
				
				Menu menu = new Menu(id, name, 1000, "");
				
				menus.add(menu);											
					
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("listview");
		
//		=========================================
		
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("	<h1>메뉴 목록</h1>");
//		out.write("	<table>");
//		out.write("		<tr>");
//		out.write("		<td>번호</td>");
//		out.write("		<td>이름</td>");
//		out.write("		<td>가격</td>	");	
//		out.write("	</tr>");
//		
//		for(int i=0; i<menus.size(); i++) {
//			Menu m = menus.get(i);
//		out.write("<tr>");	
//		out.write("	<td>"+m.getId()+"</td>");	
//		out.write("	<td>"+m.getName()+"</td>");	
//		out.write("	<td>5000</td>");				
//		out.write("</tr>");		
//		}
//		
//		out.write("</table>");	
//		out.write("</body>");	
//		out.write("</html>");	
		
		
	}
}
