package dao.bank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.bank.CustomerDTO;
import util.DBHelper;

public class CustomerDAO extends DBHelper {
	private static final CustomerDAO INSTANCE = new CustomerDAO();
	
	public static CustomerDAO getInstance() {
		return INSTANCE;
	}
	
	private CustomerDAO() {};
	
	private final String DBCP = "jdbc/bank";
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 

	public void insertCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into customer values (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getC_id());
			psmt.setString(2, dto.getC_name());
			psmt.setInt(3, dto.getC_type());
			psmt.setString(4, dto.getC_hp());			
			psmt.setString(5, dto.getC_addr());			
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public CustomerDTO selectCustomer(String c_id) {
		CustomerDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from customer where c_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CustomerDTO();
				dto.setC_id(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_type(rs.getString(3));
				dto.setC_hp(rs.getString(4));
				dto.setC_addr(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
		return dto;
	}
	
	public List<CustomerDTO> selectAllCustomer() {
		List<CustomerDTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "select * from customer";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				CustomerDTO dto = new CustomerDTO();
				dto.setC_id(rs.getString(1));
				dto.setC_name(rs.getString(2));
				dto.setC_type(rs.getString(3));
				dto.setC_hp(rs.getString(4));
				dto.setC_addr(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());			
		}
		return dtoList;
	}
	
	public void updateCustomer(CustomerDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update customer set c_name=?,c_type=?,c_hp=?,c_addr=? where c_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getC_name());
			psmt.setInt(2, dto.getC_type());
			psmt.setString(3, dto.getC_hp());
			psmt.setString(4, dto.getC_addr());
			psmt.setString(5, dto.getC_id());
	
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public void deleteCustomer(String c_id) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from customer where c_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, c_id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
}
