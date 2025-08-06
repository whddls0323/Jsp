package dao.college;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.StudentDTO;
import util.DBHelper;

public class StudentDAO extends DBHelper {
	
	private static final StudentDAO INSTANCE = new StudentDAO();
	
	public static StudentDAO getInstance() {
		return INSTANCE;
	}
	
	private StudentDAO() {}
	
	private final String DBCP = "jdbc/college";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertStudent(StudentDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into student values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getStdNo());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBirth());
			psmt.setString(4, dto.getMajor());
			psmt.setString(5, dto.getEnr_date());			
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public StudentDTO selectStudent(String stdNo) {
		StudentDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from student where stdNo=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setName(rs.getString(2));
				
				Date birthDate = rs.getDate(3);
				Date enrDate = rs.getDate(5);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				dto.setBirth(sdf.format(birthDate));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(sdf.format(enrDate));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
		
		return dto;
	}
	
	public List<StudentDTO> selectAllStudent() {
		List<StudentDTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setStdNo(rs.getString(1));
				dto.setName(rs.getString(2));
				
				Date birthDate = rs.getDate(3);
				Date enrDate = rs.getDate(5);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				dto.setBirth(sdf.format(birthDate));
				dto.setMajor(rs.getString(4));
				dto.setEnr_date(sdf.format(enrDate));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());			
		}
		
		return dtoList;
	}
	
	public void updateStudent(StudentDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update student set name=?,birth=?,major=?,enr_date=? where stdNo=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBirth());
			psmt.setString(3, dto.getMajor());
			psmt.setString(4, dto.getEnr_date());
			psmt.setString(5, dto.getStdNo());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public void deleteStudent(String stdNo) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from student where stdNo=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stdNo);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
}