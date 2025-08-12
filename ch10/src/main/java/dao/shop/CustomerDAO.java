package dao.shop;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper {
	
	private static final CustomerDAO INSTANCE = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return INSTANCE;
	}	
	
	private CustomerDAO() {}
	
	private final String DBCP = "jdbc/shop";
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCustomer(CustomerDTO dto) {		
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setString(4, dto.getAddress());
			psmt.setString(5, dto.getRdate());			
			psmt.executeUpdate();
			closeAll();			
		}catch (Exception e) {			
			//e.printStackTrace();
			logger.error(e.getMessage());
		}		
	}
	
	public CustomerDTO selectCustomer(String cid) {
		
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CustomerDTO();
				dto.setCid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setRdate(rs.getString(5));				
			}			
			closeAll();
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}		
		
		return dto;
	}
	
	public List<CustomerDTO> selectAllCustomer() {
		
		List<CustomerDTO> dtoList = new ArrayList<CustomerDTO>();
		
		try {
			conn = getConnection(DBCP);			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM CUSTOMER";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setCid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setRdate(rs.getString(5));
								
				dtoList.add(dto);
			}			
			closeAll();
		}catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}		
		return dtoList;
	}
	
	public void updateCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update customer set name=?,hp=?,address=?,rdate=? where cid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setString(3, dto.getAddress());
			psmt.setString(4, dto.getRdate());
			psmt.setString(5, dto.getCid());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteCustomer(String cid) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from customer where cid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cid);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}