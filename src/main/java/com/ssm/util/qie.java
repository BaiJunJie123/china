package com.ssm.util;

import org.aspectj.lang.ProceedingJoinPoint;

import com.alibaba.fastjson.JSONObject;

public class qie {
   
	public void qianzhi() {
		System.out.println("ǰ����ǿ");
	}
	public void houzhi() {
		
		System.out.println("������ǿ");
	}
	public void huanrao() {
		System.out.println("������ǿ");
	}
	public void zuizhong() {
		System.out.println("������ǿ");
	}
	public void huan(ProceedingJoinPoint jp) {
		
	}
}
