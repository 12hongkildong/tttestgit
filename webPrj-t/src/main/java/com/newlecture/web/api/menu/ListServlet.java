package com.newlecture.web.api.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/menus")
public class ListServlet extends HttpServlet {
	
	static List<Menu> list;
	
	static {
		list = new ArrayList<Menu>();
		list.add(new Menu(1,"아메리카노",4000,""));
		list.add(new Menu(2,"아이스 아메리카노",4500,""));
		list.add(new Menu(3,"카페라떼",5000,""));
		list.add(new Menu(4,"아이스 카페라떼",5500,""));
		list.add(new Menu(5,"카페모카",5000,""));
		list.add(new Menu(6,"아이스 카페모카",5500,""));
	}
	
	public ListServlet() {
		
	}
	// GET/POST/PUT/DELETE
	// 나~ 메뉴 목록 줘~		: GET 요청 			/admin/menus
	// 나~ 1번 메뉴 줘~			: GET 요청 			/admin/menus/1	
	// 나~ 3번 메뉴 지워줘~		: DELETE 요청			/admin/menus/3 	<-> /amdin/menus/3/del
	// 나~ 메뉴 하나 생성해줘~ 메뉴내용 전달	: POST 요청	/admin/menus	<-> /admin/menus
	// 나~ 3번 메뉴내용 이걸로 수정해줘~		: PUT 요청	/admin/menus/3	<-> /admin/menus/3/edit
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 리플렉션
		// 어노테이션
				
		String json = "{";
		
		for(Menu m : list)
			json += ?;
		
		return json;
	}
}
