package com.ssm.util;

import org.junit.Test;

public class ces {
	Shiyan sh = new Shiyan();
 
  public void show() {
	  Shiyan sh = new Shiyan();
	  for(int i =0;i<10;i++) {
		  String data = "sss"+i;
		  sh.lPush("aaa",data);
	  }
	  
  }
  public String getData() {
	  for(int i =0;i<10;i++) {
		  String ji =  sh.rpop("aaa");
		  System.out.println(ji);
	  }
		 
	  return "";
  }
  @Test
  public void newce() {
	  //show();
	  getData();
  }
}
