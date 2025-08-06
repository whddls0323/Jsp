package dao.shop;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.ProductDTO;
import util.DBHelper;

public class ProductDAO extends DBHelper {
	private static final ProductDAO INSTANCE = new ProductDAO();
	public static ProductDAO getInstance() {
		return INSTANCE;
	}
	
	private ProductDAO() {};
	
	private final String DBCP="jdbc/shop";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertProduct(ProductDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO PRODUCT VALUES (?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getPno());
			psmt.setString(2, dto.getPname());
			psmt.setInt(3, dto.getStock());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getCompany());			
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {			
			logger.error(e.getMessage());
		}	
	}
	
	public ProductDTO selectProduct(String pno) {
		ProductDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from product where pno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pno);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new ProductDTO();
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}	
		return dto;
	}
	
	public List<ProductDTO> selectAllProduct() {
		List<ProductDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "select * from product";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setPno(rs.getInt(1));
				dto.setPname(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}	
		return dtoList;
	}
	
	public void updateProduct(ProductDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update product set pname=?,stock=?,price=?,company=? where pno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPname());
			psmt.setInt(2, dto.getStock());
			psmt.setInt(3, dto.getPrice());
			psmt.setString(4, dto.getCompany());
			psmt.setInt(5, dto.getPno());
			
			psmt.executeUpdate();
			
			closeAll();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public void deleteProduct(String pno) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from product where pno=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pno);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
}
