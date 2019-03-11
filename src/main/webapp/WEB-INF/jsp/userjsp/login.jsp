<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  lang="en">
  <head>
    <base href="<%=basePath%>">
      <title>HTML5页面如何在手机端浏览器调用相机、相册功能</title>
 	 <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <body>
    
    <div>
     <!--    <input type="file" accept="image/*" capture="camera">
        <input type="file" accept="video/*" capture="camcorder">
        <input type="file" accept="audio/*" capture="microphone">
        <a href="http://localhost:8080/china/guo/success.html">aaa</a> -->
        <form action="http://127.0.0.1:8080/china/guo/success.html" method="post">
        	<input type="text" name="name" id="name"/>
        	<input type="password" name="pass" id="pass"/>
        	<input type="submit" value="提交"/>
        </form>
    </div>
    </body>
    </html>
