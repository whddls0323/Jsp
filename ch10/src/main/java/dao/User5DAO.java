package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User5DTO;
import util.DBHelper;

public class User5DAO extends DBHelper {
	//싱글톤
	private static final User5DAO INSTANCE = new User5DAO();
	
	public static User5DAO getInstance() {
		return INSTANCE;
	}
	
	private User5DAO() {};
	
	private final String DBCP = "jdbc/studydb";
	//기본 CRUD 메서드
	public void insertUser5(User5DTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into user5(name,gender,age,addr) values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			
			psmt.executeUpdate();
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public User5DTO selectUser5(String seq){
		User5DTO dto = null;
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from user5 where seq=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	};
	
	public List<User5DTO> selectAllUser5(){
		List<User5DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from user5");
			
			while(rs.next()) {
				User5DTO dto = new User5DTO();
				dto.setSeq(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setGender(rs.getString(3));
				dto.setAge(rs.getString(4));
				dto.setAddr(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	};
	
	public void updateUser5(User5DTO dto){
		try {
			conn = getConnection(DBCP);
			
			String sql = "update user5 set name=?,gender=?,age=?,addr=? where seq=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getGender());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getAddr());
			psmt.setInt(5, dto.getSeq());
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public void deleteUser5(String seq){
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from user5 where seq=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,seq);
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
	};
}
