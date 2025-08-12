package service;

import java.util.List;

import dao.User2DAO;
import dto.User2DTO;

public class User2Service {
	private static User2Service instance = new User2Service();
	
	public static User2Service getInstance() {
		return instance;
	}
	
	private User2Service() {};
	
	private User2DAO dao = User2DAO.getInstance();
	
	public void register(User2DTO dto) {
		dao.insertUser2(dto);
	}
	
	public User2DTO findById(String user_id) {
		return dao.selectUser2(user_id);
	}
	
	public List<User2DTO> findAll() {
		return dao.selectAllUser2();
	}
	
	public void modify(User2DTO dto) {
		dao.updateUser2(dto);
	}
	
	public void delete(String user_id) {
		dao.deleteUser2(user_id);
	}
}
