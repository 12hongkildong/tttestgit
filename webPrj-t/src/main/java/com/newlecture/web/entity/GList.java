package com.newlecture.web.entity;
// Generic 클래스 : 무엇이든 될 수 있는 형식
public class GList<재영> {
	
	private 재영[] data;
	private int index;
	private int max;
	
	public GList() {
		index = 0;
		max = 3;
		data = (재영[]) new Object[max];
	}
	
	public void add(재영 n) {
		// 공간이 부족하면
		if(index == max) {
			// 공간을 늘리기
			재영[] temp = (재영[]) new Object[max+3];
			for(int i=0; i<max; i++)
				temp[i] = data[i];
			
			data = temp;
			max = max+3;
		}
		
		data[index] = n;
		index++;
	}
	
	public 재영 get(int idx) {
		return data[idx];
	}
	
	public int size() {
		return index;
	}
}
