package com.ssm.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class qie {
   
	public void qianzhi() {
		System.out.println("前置增强");
	}
	public void houzhi() {
		
		System.out.println("后置增强");
	}
	public void huanrao() {
		System.out.println("环绕增强");
	}
	public void zuizhong() {
		System.out.println("最终增强");
	}
	public void huan(ProceedingJoinPoint jp) {
		
	}
}
