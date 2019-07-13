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
	UserDal dal=new UserDal();
	
	String result="匹配失败";
	List<User> list=dal.getList();
	System.out.print(userName+":::"+password);
	for(User user:list){
		System.out.print(user.getUserName()+":"+user.getPassword());
		if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
			result="成功";
		}
	}
	response.getWriter().write(result);
%>