<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="live.hmj.entity.User"%>
<%@page import="live.hmj.dal.UserDal"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="live.hmj.*" %>
<%
	response.addHeader("Access-Control-Allow-Origin", "*");//允许跨域请求
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	
	UserDal dal=new UserDal();
	User user=new User();
	user.setUserName(userName);
	user.setPassword(password);
	user.setEmail(email);
	
	String result="入库失败";
	if(dal.insertUser(user)==1){
		result="成功";
	}
	List<User> list=dal.getList();
	for(User user2:list){
		if(user2.getUserName().equals(userName)){
			result="成功";
		}
	}
	response.getWriter().write(result);
%>