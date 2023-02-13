package com.newlecture.web.entity;

import java.sql.DriverManager;

public class Menu {
	private int id;
	private String name;
	private int price;
	private String img;
	public int getId() {
		return id;
	}
	
	static {
		System.out.println("실행된당");	
		Menu menu = new Menu();
		menu.setName("아메리카노");
		System.out.println(menu);
	}
	
	public Menu(){
//		Menu menu = new Menu();
////		DriverManager.registerDriver(this);
		this(0, "", 0, null);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + "]";
	}
	public Menu(int id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}
	
	
	// 생성자(기본, 오버로드) 
	// 켓더세터    
	// toString(); -> 개체값을 문자로 뽑아내는
	// 아묻따 저 세 개 만들기
	
}
