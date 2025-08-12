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

import dto.User6DTO;

public class User6DAO {
	private final static User6DAO INSTANCE = new User6DAO();
	
	public static User6DAO getInstance() {
		return INSTANCE;
	}
	
	private User6DAO() {};
	
	public void insertUser6(User6DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("/jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "insert into user6 values(?,?,?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getSeq());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getAddr());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User6DTO selectUser6(String seq) {
		User6DTO dto = null;
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "select * from user6 where seq=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new User6DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dto.setAddr(rs.getString(5));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<User6DTO> selectAllUser6() {
		List<User6DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from user6";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User6DTO dto = new User6DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
				
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
	
	public void updateUser6(User6DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "update user6 set name=?,gender=?,age=?,addr=? where seq=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setInt(5, dto.getSeq());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser6(String seq) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "delete from user6 where seq = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}