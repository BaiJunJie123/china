package com.ssm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class WenJianChuLi {

	
	public String chuLiTxt(File file) {
		InputStream bytestr = null;
		try {
			bytestr = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader redstr = new InputStreamReader(bytestr);
		
		BufferedReader read = new BufferedReader(redstr);
		try {
			String line = null;
			int count = 0;
			while((line = read.readLine())!=null) {
				if(count%2==0) {
					String code = line.substring(line.lastIndexOf("/")+1, line.length());
					if(code.indexOf("b")==0) {
						System.out.println(code);
					}else {
						System.out.println("路径后不是以b开头");
					}
				}else if(line.indexOf("8")==0){
					System.out.println(line);
				}else {
					System.out.println("不是以8开头");
				}
				count++;
				
			}
			
			bytestr.close();
			redstr.close();
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	@Test
	public void ce() {
	  String path = "C:\\Users\\A\\Desktop\\1\\newTxt.txt";
	  File file = new File(path);
	  chuLiTxt(file);
	}
}
