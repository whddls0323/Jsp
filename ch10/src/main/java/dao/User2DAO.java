package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User2DTO;
import util.DBHelper;

public class User2DAO extends DBHelper {
	//싱글톤
	private static final User2DAO INSTANCE = new User2DAO();
	
	public static User2DAO getInstance() {
		return INSTANCE;
	}
	
	private User2DAO() {};
	
	private final String DBCP = "jdbc/studydb";
	//기본 CRUD 메서드
	public void insertUser2(User2DTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into user2 values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public User2DTO selectUser2(String uid){
		User2DTO dto = null;
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from user2 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User2DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setAddr(rs.getString(4));
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	};
	
	public List<User2DTO> selectAllUser2(){
		List<User2DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from user2");
			
			while(rs.next()) {
				User2DTO dto = new User2DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setAddr(rs.getString(4));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	};
	
	public void updateUser2(User2DTO dto){
		try {
			conn = getConnection(DBCP);
			
			String sql = "update user2 set name=?,birth=?,addr=? where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getAddr());
			psmt.setString(4, dto.getUid());
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public void deleteUser2(String uid){
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from user2 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,uid);
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
}
