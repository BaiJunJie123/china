package com.ssm.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
public class OssUtils {
	private static final Logger LOG = LoggerFactory.getLogger(OssUtils.class);
	
	//阿里云API的内或外网域名
		private static String ENDPOINT;
		//阿里云API的密钥Access Key ID
		private static String ACCESS_KEY_ID;
		//阿里云API的密钥Access Key Secret
		private static String ACCESS_KEY_SECRET;
		
		// 从配置文件中得到值
		static {
			// 解决国际化统一
			/*ResourceBundle bundle = PropertyResourceBundle.getBundle("oss.properties");*/
			ENDPOINT ="oss-cn-beijing.aliyuncs.com"; /*bundle.containsKey("endpoint") == false ? "" : bundle.getString("endpoint");*/
			ACCESS_KEY_ID ="LTAI1GibKd8lf6kq"; /*bundle.containsKey("accessKeyId") == false? "" : bundle.getString("accessKeyId");
*/			ACCESS_KEY_SECRET ="OkgHfPKnsTWqhmBSrQmA91OZXU2Elk";/* bundle.containsKey("accessKeySecret") == false ? "" : bundle.getString("accessKeySecret");*/

		}
		
		/**
		 * 获取阿里云OSS客户端对象
		 * */
		public static final OSSClient getOSSClient(){
			return new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		}
		 
		/**
		 * 新建Bucket  --Bucket权限:私有
		 * @param bucketName bucket名称
		 * @return true 新建Bucket成功
		 * */
		//  bucket 指图片在阿里云上的存储空间
		public static final boolean createBucket(OSSClient client, String bucketName){
			Bucket bucket = client.createBucket(bucketName); 
			return bucketName.equals(bucket.getName());
		}
		/**
		 * 删除Bucket 
		 * @param bucketName bucket名称
		 * */
		public static final void deleteBucket(OSSClient client, String bucketName){
			client.deleteBucket(bucketName); 
			LOG.info("删除" + bucketName + "Bucket成功");
		}
		
		/**
		 * 向阿里云的OSS存储中存储文件  --file也可以用InputStream替代
		 * @param client OSS客户端
		 * @param file 上传文件
		 * @param bucketName bucket名称
		 * @param diskName 上传文件的目录  --bucket下文件的路径
		 * @return String 唯一MD5数字签名
		 * */
		public static final String uploadObject2OSS(OSSClient client, File file, String bucketName, String diskName) {
			String resultStr = null;
			try {
				InputStream is = new FileInputStream(file);//先把文件读到输入流中
				//InputStream ss = new FileInputStream(file);
				String fileName = file.getName();  //得到文件名
				//String fileName = file.getName();
				Long fileSize = file.length();  // 得到文件的长度
				//Long ss = file.length(); 
				//创建上传Object的Metadata
				ObjectMetadata metadata = new ObjectMetadata();
				//设置Content-Length HTTP标头，以字节为单位指示关联对象的大小。
				metadata.setContentLength(is.available());  //available() 这个方法可以在读写操作前先得知数据流里有多少个字节可以读取
				//设置可选的Cache-Control HTTP标头，允许用户指定HTTP请求/回复链中的缓存行为。
				metadata.setCacheControl("no-cache");
				// 仅限内部使用
				metadata.setHeader("Pragma", "no-cache");
				metadata.setContentEncoding("utf-8");
				metadata.setContentType(getContentType(fileName));
				metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
				//上传文件 
				PutObjectResult putResult = client.putObject(bucketName, diskName + fileName, is, metadata);
				//解析结果
				resultStr = putResult.getETag();
			} catch (Exception e) {
				LOG.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
			}
			return resultStr;
		}
		
		 /** 
	     * 根据key获取OSS服务器上的文件输入流
	 	 * @param client OSS客户端
	 	 * @param bucketName bucket名称
	 	 * @param diskName 文件路径
	 	 * @param key Bucket下的文件的路径名+文件名
	     */  
	     public static final InputStream getOSS2InputStream(OSSClient client, String bucketName, String diskName, String key){ 
			OSSObject ossObj = client.getObject(bucketName, diskName + key);
			return ossObj.getObjectContent();	
	     }  
		
	   /** 
	    * 根据key删除OSS服务器上的文件 
	  	* @param client OSS客户端
	  	* @param bucketName bucket名称
	  	* @param diskName 文件路径
	  	* @param key Bucket下的文件的路径名+文件名
	    */  
		  public static void deleteFile(OSSClient client, String bucketName, String diskName, String key){  
		  	client.deleteObject(bucketName, diskName + key); 
		  	LOG.info("删除" + bucketName + "下的文件" + diskName + key + "成功");
		  }  

		/** 
	     * 通过文件名判断并获取OSS服务文件上传时文件的contentType 
	     * @param fileName 文件名
	     * @return 文件的contentType   
	     */  
	     public static final String getContentType(String fileName){  
	    	String fileExtension = fileName.substring(fileName.lastIndexOf("."));
	    	if("bmp".equalsIgnoreCase(fileExtension)) return "image/bmp";
	    	if("gif".equalsIgnoreCase(fileExtension)) return "image/gif";
	    	if("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension)  || "png".equalsIgnoreCase(fileExtension) ) return "image/jpeg";
	    	if("html".equalsIgnoreCase(fileExtension)) return "text/html";
	    	if("txt".equalsIgnoreCase(fileExtension)) return "text/plain";
	    	if("vsd".equalsIgnoreCase(fileExtension)) return "application/vnd.visio";
	    	if("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) return "application/vnd.ms-powerpoint";
	    	if("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) return "application/msword";
	    	if("xml".equalsIgnoreCase(fileExtension)) return "text/xml";
	        return "text/html";  
	     }  

	
}
