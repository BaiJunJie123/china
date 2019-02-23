package com.ssm.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import sun.misc.BASE64Encoder;
public class RenLian {
	@Test
	public void puanDuanLian() {
		
		  String url = "https://api-cn.faceplusplus.com/facepp/v3/compare";
		  String  api_key = "65Ju7nO8E-V24cBGoRdcId6Vdd74dAjs";
		  String api_secret = "NcIGUI2j6ZQR2zQA40zPyU3PeKTBVv7H";
		  CloseableHttpClient http = HttpClients.createDefault(); 
		  HttpPost post = new HttpPost(url);
		  post.setHeader("Accept", "application/json");
		  post.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
		  post.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
	     File file = new File("C:\\Users\\26044\\Desktop\\bjj\\3.jpg");
		 File file2 = new File("C:\\Users\\26044\\Desktop\\bjj\\3.jpg");
		  ByteArrayOutputStream out = new ByteArrayOutputStream();
		  ByteArrayOutputStream out2 = new ByteArrayOutputStream();
		  BufferedImage image;
		  BufferedImage image2;
		try {
			image = ImageIO.read(file);
			ImageIO.write(image, "jpg", out);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			image2 = ImageIO.read(file2);
			ImageIO.write(image2, "jpg", out2);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		  
		  byte[] bytes = out.toByteArray();
		  byte[] bytes2 = out2.toByteArray();
		  String one = new BASE64Encoder().encode(bytes);
		  String two = new BASE64Encoder().encode(bytes2);
		  try {
			out.close();
			out2.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 List<NameValuePair> list  = new ArrayList<NameValuePair>();
		 list.add(new BasicNameValuePair("api_key", api_key));
		 list.add(new BasicNameValuePair("api_secret", api_secret));
		 list.add(new BasicNameValuePair("image_base64_1", one));
		 list.add(new BasicNameValuePair("image_base64_2", two));
		 try {
			post.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			HttpResponse response = http.execute(post);
			System.out.println(response.getStatusLine().getStatusCode());
			if(response!= null && response.getStatusLine().getStatusCode()==200) {
				HttpEntity entity = response.getEntity();
				String ss = EntityUtils.toString(entity);
				JSONObject json = JSONObject.parseObject(ss);
				 String zhi =json.get("confidence").toString();
				 if(Double.valueOf(zhi)>90.0) {
					 System.out.println("是同1个人");
					 
				 }else {
					 System.out.println("不是同一个人");
				 }
				http.close();
			}else {
				System.out.println("失败");
				
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
}
