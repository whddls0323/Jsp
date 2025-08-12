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

import dto.User7DTO;

public class User7DAO {
	private final static User7DAO INSTANCE = new User7DAO();
	
	public static User7DAO getInstance() {
		return INSTANCE;
	}
	
	private User7DAO() {};
	
	public void insertUser7(User7DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("/jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "insert into user7(name,age,email) values(?,?,?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getEmail());
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User7DTO selectUser7(String id) {
		User7DTO dto = null;
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "select * from user7 where id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new User7DTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setEmail(rs.getString(4));
			}
			
			rs.close();
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<User7DTO> selectAllUser7() {
		List<User7DTO> dtoList = new ArrayList<>();
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from user7";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User7DTO dto = new User7DTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setEmail(rs.getString(4));
				
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
	
	public void updateUser7(User7DTO dto) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "update user7 set name=?,age=?,email=? where id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getAge());
			psmt.setString(3, dto.getEmail());
			psmt.setInt(4, dto.getId());

			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser7(String id) {
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/whddls0323");
			
			Connection conn = ds.getConnection();
			
			String sql = "delete from user7 where id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}