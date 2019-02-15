package com.ssm.util;

public class Fanxing<T> {
   
	private T data;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void show(T t) {
		System.out.println(t.toString());
	}
}
