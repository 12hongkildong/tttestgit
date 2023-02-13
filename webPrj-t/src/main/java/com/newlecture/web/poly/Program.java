package com.newlecture.web.poly;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
		
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List list = new ArrayList();
//		list.add("3");
//		list.add("15");
//		list.add("2");
//		list.add("6");
//		list.add(3);
//		list.add(15);
//		list.add(2);
//		list.add(6);
		list.add(new Exam(1,3,2));
		list.add(new Exam(10,20,30));
		list.add(new Exam(60,50,40));
		list.add(new Exam(3,4,5));
		list.sort((x,y)->((Exam)y).getKor()-((Exam)x).getKor());
		System.out.println(list);
		
		//Banner banner = new ICTBanner();
		// 메소드 내부 클래스
		class AAA implements Banner {

			@Override
			public void print() {
				System.out.println("   내부 클래스 ICT 교육센터 ");
			}			
		}
		// 익명 클래스
		Banner banner1 = new Banner() {

			@Override
			public void print() {
				System.out.println("   익명 클래스 ICT 교육센터 ");
			}
			
		};
		
//		Exam.printIntro(()->{
//			System.out.println("   Lamda 익명 클래스 ICT 교육센터 ");
//		});
	}

}
