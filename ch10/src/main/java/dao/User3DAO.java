package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User3DTO;
import util.DBHelper;

public class User3DAO extends DBHelper {
	//싱글톤
	private static final User3DAO INSTANCE = new User3DAO();
	
	public static User3DAO getInstance() {
		return INSTANCE;
	}
	
	private User3DAO() {};
	
	private final String DBCP = "jdbc/studydb";
	//기본 CRUD 메서드
	public void insertUser3(User3DTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into user3 values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public User3DTO selectUser3(String uid){
		User3DTO dto = null;
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from user3 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User3DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	};
	
	public List<User3DTO> selectAllUser3(){
		List<User3DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from user3");
			
			while(rs.next()) {
				User3DTO dto = new User3DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setBirth(rs.getString(3));
				dto.setHp(rs.getString(4));
				dto.setAddr(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	};
	
	public void updateUser3(User3DTO dto){
		try {
			conn = getConnection(DBCP);
			
			String sql = "update user3 set name=?,birth=?,hp=?,addr=? where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddr());
			psmt.setString(5, dto.getUid());
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public void deleteUser3(String uid){
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from user3 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,uid);
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
}
