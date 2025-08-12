<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "update user4 set gender=?,age=?,addr=? where name=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,gender);
		psmt.setString(2,age);
		psmt.setString(3,addr);
		psmt.setString(4,name);
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	response.sendRedirect("../list.jsp");
%>