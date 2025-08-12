package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.User5DTO;

public class User5DAO {
	private final static User5DAO INSTANCE = new User5DAO();
	
	public static User5DAO getInstance() {
		return INSTANCE;
	}
	
	private User5DAO() {};
	
	public void insertUser5(User5DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "insert into user5 values(?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User5DTO selectUser5(String name) {
		User5DTO dto = null;
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "select * from user5 where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new User5DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setAddr(rs.getString(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<User5DTO> selectAllUser5() {
		List<User5DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from user5";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setName(rs.getString(1));
				dto.setGender(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setAddr(rs.getString(4));
				
				dtoList.add(dto);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void updateUser5(User5DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "update user5 set gender=?,age=?,addr=? where name=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getGender());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getName());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser5(String name) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "delete from user5 where name = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}