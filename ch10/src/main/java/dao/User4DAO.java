package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User4DTO;
import util.DBHelper;

public class User4DAO extends DBHelper {
	//싱글톤
	private static final User4DAO INSTANCE = new User4DAO();
	
	public static User4DAO getInstance() {
		return INSTANCE;
	}
	
	private User4DAO() {};
	
	private final String DBCP = "jdbc/studydb";
	//기본 CRUD 메서드
	public void insertUser4(User4DTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into user4 values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getGender());
			psmt.setString(4, dto.getAge());
			psmt.setString(5, dto.getHp());
			psmt.setString(6, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public User4DTO selectUser4(String uid){
		User4DTO dto = null;
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from user4 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User4DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setAddr(rs.getString(6));
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	};
	
	public List<User4DTO> selectAllUser4(){
		List<User4DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from user4");
			
			while(rs.next()) {
				User4DTO dto = new User4DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setHp(rs.getString(5));
				dto.setAddr(rs.getString(6));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	};
	
	public void updateUser4(User4DTO dto){
		try {
			conn = getConnection(DBCP);
			
			String sql = "update user4 set name=?,gender=?,age=?,hp=?,addr=? where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setString(3, dto.getAge());
			psmt.setString(4, dto.getHp());
			psmt.setString(5, dto.getAddr());
			psmt.setString(6, dto.getUid());
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public void deleteUser4(String uid){
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from user4 where uid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,uid);
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
}
