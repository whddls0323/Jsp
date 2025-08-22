package dao.bank;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.bank.AccountDTO;
import util.DBHelper;

public class AccountDAO extends DBHelper {
	private static final AccountDAO INSTANCE = new AccountDAO();
	
	public static AccountDAO getInstance() {
		return INSTANCE;
	}
	
	private AccountDAO() {};
	
	private final String DBCP = "jdbc/bank";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into account values (?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getAcc_no());
			psmt.setString(2, dto.getAcc_type());
			psmt.setString(3, dto.getAcc_name());
			psmt.setString(4, dto.getAcc_cid());		
			psmt.setInt(5, dto.getAcc_balance());		
			psmt.setString(6, dto.getAcc_date());		
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public AccountDTO selectAccount(String acc_no) {
		AccountDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from account where acc_no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, acc_no);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getString(6));
				System.out.println(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
		return dto;
	}
	
	public List<AccountDTO> selectAllAccount() {
		List<AccountDTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "select * from account";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				AccountDTO dto = new AccountDTO();
				dto.setAcc_no(rs.getString(1));
				dto.setAcc_type(rs.getString(2));
				dto.setAcc_name(rs.getString(3));
				dto.setAcc_cid(rs.getString(4));
				dto.setAcc_balance(rs.getInt(5));
				dto.setAcc_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());			
		}
		return dtoList;
	}
	
	public void updateAccount(AccountDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update account set acc_type=?,acc_name=?,acc_cid=?,acc_balance=?,acc_date=? where acc_no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getAcc_type());
			psmt.setString(2, dto.getAcc_name());
			psmt.setString(3, dto.getAcc_cid());		
			psmt.setInt(4, dto.getAcc_balance());		
			psmt.setString(5, dto.getAcc_date());	
			psmt.setString(6, dto.getAcc_no());
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public void deleteAccount(String acc_no) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from account where acc_no=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, acc_no);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
}
