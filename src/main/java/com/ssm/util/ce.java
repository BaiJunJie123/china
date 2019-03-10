package com.ssm.util;


import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.ssm.service.serviceUsers.one;

public class ce {
	  @Test
	 public void show() {
		 
		 OssUtils oss = new OssUtils();
		 File wen = new File("C:\\Users\\A\\Desktop\\abc\\1.jpg");
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 String time = sdf.format(new Date());
		 //System.out.println(time);
		 String ss = oss.uploadObject2OSS(oss.getOSSClient(), wen, "oss-test-mys", "datas/image/"+time+"/");
		 System.out.println(ss);
	 }
	 @Test
	 public void xia() {
		 OssUtils oss = new OssUtils();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 String time = sdf.format(new Date());
		 InputStream in = oss.getOSS2InputStream(oss.getOSSClient(), "oss-test-mys", "datas/image/20190215/", "1.jpg");
		
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 int b =0;
		 try {
			 FileOutputStream fileout = new FileOutputStream(new File("C:\\Users\\A\\Desktop\\111\\bjj.jpg"));
			 byte[] zu = new byte[2048];
			while((b=in.read(zu))>-1) {
				 //out.write
			 }
			in.close();
			out.write(zu);
			fileout.write(out.toByteArray());
			fileout.flush();
			fileout.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
	 public void ss() {
		 byte[] zu = new byte[1024];
		 File file = new File("");
		 try {
			OutputStream out  = new FileOutputStream(file);
			BufferedOutputStream buf = new BufferedOutputStream(out);
			try {
				buf.write(zu);
				buf.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 @Test
	 public void show2() {
		
		 
	 }
}
