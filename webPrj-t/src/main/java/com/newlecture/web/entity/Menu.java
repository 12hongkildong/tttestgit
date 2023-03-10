package com.newlecture.web.entity;

public class Menu {
	private int id;
	private String name;
	private int price;
	private String img;
	
	// 생성자(기본,오버로드)
	// Getters/Setters
	// toString();
	
	static {
		System.out.println("실행되지롱 Menu 전역 초기화");
		
		Menu menu = new Menu();
		menu.setName("아메리 아메리카노~");
		System.out.println(menu);
//				DriverManager.registerDriver(this);
	}
	
	public Menu() {
		// TODO Auto-generated constructor stub
		
	}

	public Menu(int id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public int getId() {
		return id;
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
	
	
}
