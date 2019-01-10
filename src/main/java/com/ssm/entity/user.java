package com.ssm.entity;

import java.io.Serializable;
import java.util.Date;

public class user implements Serializable{
 private int id;
 private String real_name;
 private String login_name;
 private String mobile;
 private String weixin;
 private String id_card;
 private String agent_code;
 private int parent;
 private String remittance;
 private int referrer;
 private String agent_status;
 private String user_status;
 private String password;
 private Date update_time;
 private int version;
 private int operator;
 private String wx_openid;
 private String nick_name;
 private char identity;
 private String last_visit_ip;
 private Date last_visit_time;
 private String sub_domain;
 private Date join_date;
 private String login_token;
 private int teqparent;
 private String head_imgurl;
 private String wx_unionid;
 private String pay_openid;
 private char needCheck;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getReal_name() {
	return real_name;
}
public void setReal_name(String real_name) {
	this.real_name = real_name;
}
public String getLogin_name() {
	return login_name;
}
public void setLogin_name(String login_name) {
	this.login_name = login_name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getWeixin() {
	return weixin;
}
public void setWeixin(String weixin) {
	this.weixin = weixin;
}
public String getId_card() {
	return id_card;
}
public void setId_card(String id_card) {
	this.id_card = id_card;
}
public String getAgent_code() {
	return agent_code;
}
public void setAgent_code(String agent_code) {
	this.agent_code = agent_code;
}
public int getParent() {
	return parent;
}
public void setParent(int parent) {
	this.parent = parent;
}
public String getRemittance() {
	return remittance;
}
public void setRemittance(String remittance) {
	this.remittance = remittance;
}
public int getReferrer() {
	return referrer;
}
public void setReferrer(int referrer) {
	this.referrer = referrer;
}
public String getAgent_status() {
	return agent_status;
}
public void setAgent_status(String agent_status) {
	this.agent_status = agent_status;
}
public String getUser_status() {
	return user_status;
}
public void setUser_status(String user_status) {
	this.user_status = user_status;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Date getUpdate_time() {
	return update_time;
}
public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}
public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
public int getOperator() {
	return operator;
}
public void setOperator(int operator) {
	this.operator = operator;
}
public String getWx_openid() {
	return wx_openid;
}
public void setWx_openid(String wx_openid) {
	this.wx_openid = wx_openid;
}
public String getNick_name() {
	return nick_name;
}
public void setNick_name(String nick_name) {
	this.nick_name = nick_name;
}
public char getIdentity() {
	return identity;
}
public void setIdentity(char identity) {
	this.identity = identity;
}
public String getLast_visit_ip() {
	return last_visit_ip;
}
public void setLast_visit_ip(String last_visit_ip) {
	this.last_visit_ip = last_visit_ip;
}
public Date getLast_visit_time() {
	return last_visit_time;
}
public void setLast_visit_time(Date last_visit_time) {
	this.last_visit_time = last_visit_time;
}
public String getSub_domain() {
	return sub_domain;
}
public void setSub_domain(String sub_domain) {
	this.sub_domain = sub_domain;
}
public Date getJoin_date() {
	return join_date;
}
public void setJoin_date(Date join_date) {
	this.join_date = join_date;
}
public String getLogin_token() {
	return login_token;
}
public void setLogin_token(String login_token) {
	this.login_token = login_token;
}
public int getTeqparent() {
	return teqparent;
}
public void setTeqparent(int teqparent) {
	this.teqparent = teqparent;
}
public String getHead_imgurl() {
	return head_imgurl;
}
public void setHead_imgurl(String head_imgurl) {
	this.head_imgurl = head_imgurl;
}
public String getWx_unionid() {
	return wx_unionid;
}
public void setWx_unionid(String wx_unionid) {
	this.wx_unionid = wx_unionid;
}
public String getPay_openid() {
	return pay_openid;
}
public void setPay_openid(String pay_openid) {
	this.pay_openid = pay_openid;
}
public char getNeedCheck() {
	return needCheck;
}
public void setNeedCheck(char needCheck) {
	this.needCheck = needCheck;
}
public user(int id, String real_name, String login_name, String mobile, String weixin, String id_card,
		String agent_code, int parent, String remittance, int referrer, String agent_status, String user_status,
		String password, Date update_time, int version, int operator, String wx_openid, String nick_name, char identity,
		String last_visit_ip, Date last_visit_time, String sub_domain, Date join_date, String login_token,
		int teqparent, String head_imgurl, String wx_unionid, String pay_openid, char needCheck) {
	super();
	this.id = id;
	this.real_name = real_name;
	this.login_name = login_name;
	this.mobile = mobile;
	this.weixin = weixin;
	this.id_card = id_card;
	this.agent_code = agent_code;
	this.parent = parent;
	this.remittance = remittance;
	this.referrer = referrer;
	this.agent_status = agent_status;
	this.user_status = user_status;
	this.password = password;
	this.update_time = update_time;
	this.version = version;
	this.operator = operator;
	this.wx_openid = wx_openid;
	this.nick_name = nick_name;
	this.identity = identity;
	this.last_visit_ip = last_visit_ip;
	this.last_visit_time = last_visit_time;
	this.sub_domain = sub_domain;
	this.join_date = join_date;
	this.login_token = login_token;
	this.teqparent = teqparent;
	this.head_imgurl = head_imgurl;
	this.wx_unionid = wx_unionid;
	this.pay_openid = pay_openid;
	this.needCheck = needCheck;
}
public user() {
	super();
}
 
}
