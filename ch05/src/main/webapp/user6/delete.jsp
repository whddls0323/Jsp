<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");

	String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "whddls0323"; 
	String pass = "1234";
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host,user,pass);
		
		String sql = "delete from user6 where seq=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,seq);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close(); 
	} catch(Exception e) {
		e.printStackTrace();
	} 
	
	response.sendRedirect("./list.jsp");
%>