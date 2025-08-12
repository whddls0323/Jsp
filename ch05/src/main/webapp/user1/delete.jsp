<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//전송 데이터 수신
	String user_id = request.getParameter("user_id");
	
	String host = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String user = "whddls0323"; 
	String pass = "1234";
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		String sql = "delete from user1 where user_id = ?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,user_id);
		
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	//목록이동
	response.sendRedirect("./list.jsp");
%>

