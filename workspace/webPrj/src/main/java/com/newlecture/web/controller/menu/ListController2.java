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
import java.util.Scanner;

import com.newlecture.web.entity.GList;
import com.newlecture.web.entity.Menu;
import com.newlecture.web.entity.NList;
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
       
	   
	   resp.setCharacterEncoding("UTF-8"); // 브라우저에게 utf-8로 읽으라는 명령  
	   resp.setContentType("text/html;charset=utf-8");
//	   resp.setContentType("text/txt;charset=utf-8");
	  
	   List<Menu> list = new ArrayList<>() ; // 가변길이배열 // 모든 파일(?)에 사용되니 최상단으로 빼놓자
	   
      PrintWriter out = resp.getWriter();
      out.print("hello");
      
//      Menu[] list = service.getList();
//      int count = service.count();
      
   String query = "";
   String sql =String.format("select * from member where nicname like '%s'", "%"+query+"%") ;
//   Scanner scan= new  Scanner(System.in);   
//   String sql = scan.nextLine(); 
     
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
         Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
         
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         

//         Menu[] menus = new Menu[100]; // 고정크기배열\

//         List<Menu> list = new ArrayList<>(); // 콜렉션
         
         // 필터링, 집계, 정렬
         while(rs.next())   // 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
         {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String nicName = rs.getString("nicname");
            
//            out.println("<table>");
//            out.println("<tr>");
            
            //String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
//			out.println(format + "<br >");  // format은 한 번 출력되고 그 다음은 출력이 안 될까?
//            out.println(format);
//            out.println("<tr>");
//            out.println("</table>");
            
            Menu menu = new Menu(id, name, 1000, "");
            list.add(menu);
//            menus.add(3);
//            Object n = new Integer(3);

         }
         
         con.close();
         
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      req.setAttribute("menus", list);
//      resp.sendRedirect("listview");
      req.getRequestDispatcher("listview").forward(req,resp);
      
      
//      =========================================출력코드
      
//      out.write("<!DOCTYPE html>");   // 반복하지 말아야 할 것
//      out.write("<html>");
//      out.write("<head>");
//      out.write("<meta charset=\"EUC-KR\">"); //  문자열 사이에 "가 있으니까 역슬레시를 적어준다.
//      out.write("<title>Insert title here</title>");
//      out.write("</head>");
//      out.write("<body>");
//      out.write("<h1>메뉴목록</h1>");
//      out.write("<table>");
//      out.write("<tr>");
//      out.write("         			<td>번호</td>");
//      out.write("         			<td>이름</td>");
//      out.write("         			<td>가격</td>");
//      out.write("</tr>");
//      
//      for(int i=0 ; i<menus.size() ; i++) {
//    	  Menu m = menus.get(i);
//      out.write("<tr>");                 // 반복 출력할 녀석
//      out.write("<td>"+m.getId()+"</td>");
//      out.write("<td>"+m.getName()+"</td>");
//      out.write("<td>5000</td>");
//      out.write("</tr>");
//      }
//      out.write("</table>");
//      out.write("</body>");
//      out.write("</html>");

      
   }
}