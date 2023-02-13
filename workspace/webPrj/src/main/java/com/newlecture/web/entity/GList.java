package com.newlecture.web.entity;

public class GList<재영> {
	
	private 재영[] data;
	private int max;
	private int index;
	
	public GList() {
		index=0;
		max=3;
		data = (재영[]) new Object[max];
	}
	
	public void add(재영 n) {
		// 공간이 부족하면 공간을 자동으로 늘려주자
		if(index==max) {
			재영[] temp = (재영[]) new Object[max+3];
			for(int i=0 ; i<max ; i++)
				temp[i]=data[i];
			data=temp;
			max+=3;
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
