<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "whddls0323";
	String pass = "1234";
	
	try {
		
	} catch(Exception e) {
		e.printStackTrace();
	}
%>