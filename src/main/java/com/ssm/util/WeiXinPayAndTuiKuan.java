package com.ssm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.Response;

public class WeiXinPayAndTuiKuan {
	
	//支付
	@Test
	public void zhiFu() {
		 String key = "huangfei08huanfgei99huangfei1234";
		String appid ="wx0a073be92a917ed3"; //公众账号ID
		String mch_id ="1494938712"; //商户号
		//String  device_info = "013467007045768";
		String openid = "oUpF8uMuAJO_M2pxb";
		String nonce_str = "3kG00g7iTjwQnJsynySJhKazn3l"; //随机字符串
		String body = "abcdedd";   //商品描述
		String out_trade_no = "1b59246236394538b1ad638fa3af246f"; //商户订单号 32个字符以内
		String product_id = "12235413214070356458058";
		String  total_fee ="8500"; //标价金额
		String spbill_create_ip = "112.231.144.244"; // 终端IP
		String notify_url ="http://ht.kam365.com/kam/dmz/pmall/shopcart/wxPay.json"; // http://www.kam365.com/kam/login.html
		String trade_type = "JSAPI";//JSAPI NATIVE
		String sign_type  = "MD5";
		Map<String, String> map = new HashMap<String,String>();
		 
		
		map.put("sign_type",sign_type);
		map.put("openid", openid);
		map.put("product_id",product_id);
		map.put("appid",appid);
		map.put("mch_id",mch_id);
		map.put("nonce_str",nonce_str);
		map.put("body",body);
		map.put("out_trade_no",out_trade_no);
		map.put("total_fee",total_fee);
		map.put("spbill_create_ip",spbill_create_ip);
		map.put("notify_url",notify_url);
		map.put("trade_type",trade_type);
		String 	pams = ww.formatUrlMap(map, true, false); /*"appid="+appid+"&mch_id="+mch_id+"&nonce_str="+nonce_str+"&sign_type="+sign_type+"&body="+body+"&product_id="+product_id+"&out_trade_no="+out_trade_no+"&total_fee="+total_fee+"&spbill_create_ip="+spbill_create_ip+"&notify_url="+notify_url+"&trade_type="+trade_type+"&key="+key;*///签名	sign
		String pam = pams+"&key="+key;
		//String sign = Md5.MD5Encode(pam).toUpperCase();
		//String sign =ww.md5Password(pam);
		String sign = DigestUtils.md5Hex(pam).toUpperCase();
		System.out.println(sign);
		map.put("sign", sign);
		String json = JSON.toJSONString(map);
		System.out.println(json);
		//appid=wx0a073be92a917ed3&body=咖盟商城
		//&mch_id=1494938712&nonce_str=3kG00g7iTjwQnJsynySJhKazn3lEiweM
		//&notify_url=http://ht.kam365.com/kam/dmz/pmall/shopcart/wxPay.json
		//&out_trade_no=1b59246236394538b1ad638fa3af246f&total_fee=8500&trade_type=JSAPI
		//&key=huangfei08huanfgei99huangfei1234我的签名
		HttpClient http = HttpClients.createDefault();
		HttpPost post = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
		post.addHeader("Accept","application/json");
		post.addHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
		post.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
		post.setEntity(new StringEntity(XmlJson.json2xml(json), Charset.forName("UTF-8")));
		try {
		  HttpResponse response =http.execute(post);
		  if(response!=null && response.getStatusLine().getStatusCode()==200) {
			  HttpEntity entity = response.getEntity();
			  String zhi = EntityUtils.toString(entity, "UTF-8");
			  System.out.println(zhi);
		  }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			  System.out.println("支付失败");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			  System.out.println("支付失败");
			e.printStackTrace();
		}
		
 		//return "";
		
	}
	@Test
	//cha
	public void tuiKuan() {
		 String key = "huangfei08huanfgei99huangfei1234";
		String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
		String appid ="wx0a073be92a917ed3"; //公众账号ID
		String mch_id ="1494938712"; //商户号
		String out_trade_no = "b4d4bd973ab44336989c88c8c0336cda";
		String nonce_str = "3kG00g7iTjwQnJsynySJhKazn3l"; //随机字符串
		String out_refund_no = "sdf45fgdg45btr4543c234"; //商户退款单号
		String total_fee = "1100";
		String refund_fee = "100";
		Map<String,String> map = new HashMap<>();
		map.put("appid",appid);
		map.put("mch_id",mch_id);
		map.put("out_trade_no",out_trade_no);
		map.put("nonce_str",nonce_str);
		map.put("out_refund_no",out_refund_no);
		map.put("total_fee",total_fee);
		map.put("refund_fee",refund_fee);
		String pam = ww.formatUrlMap(map, true, false);
		String sgin = pam+"&key="+key;
		String sing = DigestUtils.md5Hex(sgin).toUpperCase();
		map.put("sign", sing);
		//需要导入证书声明
		HttpClient http = HttpClients.createDefault();
		
		HttpPost post = new HttpPost(url);
		post.addHeader("Accept","application/json");
		post.addHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
		post.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
		String json = JSON.toJSONString(map);
		post.setEntity(new StringEntity(XmlJson.json2xml(json),Charset.forName("UTF-8")));
		try {
			HttpResponse response = http.execute(post);
			if(response!=null && response.getStatusLine().getStatusCode()==200) {
				HttpEntity entity= response.getEntity();
				String zhi = EntityUtils.toString(entity,"UTF-8");
				System.out.println(zhi);
				
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "";
	}
	@Test
	public void huo() {
		String path = "";//证书路径
		String MCH_ID = ""; ////下载证书时的密码、默认密码是你的MCHID mch_id
		KeyStore keystore =null;
		try {
			//加载和保存PKCS＃12文件，其中包含私钥条目（私钥和证书链）和证书条目（X.509证书）
			//如果要实例化a KeyStore，指定密钥库类型和提供程序
			keystore = KeyStore.getInstance("PKCS12");
			
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream in = null;
		try {
			 in = new FileInputStream(new File(path));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			keystore.load(in,MCH_ID.toCharArray());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		SSLContext sslcontext = null;
		//此类的实例表示安全套接字协议的实现， 它是SSLSocketFactory、SSLServerSocketFactory和SSLEngine的工厂
		try {
			 sslcontext = SSLContexts.custom().loadKeyMaterial(keystore, MCH_ID.toCharArray()).build();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SSLConnectionSocketFactory ssl = new SSLConnectionSocketFactory(sslcontext,new String[] {"TLSv1"},null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		
		CloseableHttpClient http = HttpClients.custom().setSSLSocketFactory(ssl).build();
		//httpost.addHeader("Host", "api.mch.weixin.qq.com");
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(System.currentTimeMillis());
	}
	
	
}
