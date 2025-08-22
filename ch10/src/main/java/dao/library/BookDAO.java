package dao.library;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.library.BookDTO;
import util.DBHelper;

public class BookDAO extends DBHelper {
	private static final BookDAO INSTANCE = new BookDAO();
	
	public static BookDAO getInstance() {
		return INSTANCE;
	}
	
	private BookDAO() {};
	
	private final String DBCP = "jdbc/library";
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "insert into book values (?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getBook_id());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAuthor());
			psmt.setString(4, dto.getPublisher());			
			psmt.setString(5, dto.getAvailable());			
			psmt.setString(6, dto.getReg_date());			
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public BookDTO selectBook(String book_id) {
		BookDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "select * from book where book_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book_id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
		return dto;
	}
	
	public List<BookDTO> selectAllBook() {
		List<BookDTO> dtoList = new ArrayList<>();
		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();
			
			String sql = "select * from book";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getString(6));
				
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());			
		}
		return dtoList;
	}
	
	public void updateBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "update book set title=?,author=?,publisher=?,available=?,reg_date=? where book_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getAuthor());
			psmt.setString(3, dto.getPublisher());
			psmt.setString(4, dto.getAvailable());
			psmt.setString(5, dto.getReg_date());
			psmt.setInt(6, dto.getBook_id());
	
			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
	
	public void deleteBook(String book_id) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "delete from book where book_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book_id);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error(e.getMessage());		
		}
	}
}
