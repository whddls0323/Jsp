<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "whddls0323"; 
	String pass = "1234";
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		String sql = "insert into user6 values(?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,seq);
		psmt.setString(2,name);
		psmt.setString(3,gender);
		psmt.setString(4,age);
		psmt.setString(5,addr);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("../list.jsp");
%>