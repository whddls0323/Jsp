package service;

import java.util.List;

import dao.User6DAO;
import dto.User6DTO;

public class User6Service {
	private static User6Service instance = new User6Service();
	
	public static User6Service getInstance() {
		return instance;
	}
	
	private User6Service() {};
	
	private User6DAO dao = User6DAO.getInstance();
	
	public void register(User6DTO dto) {
		dao.insertUser6(dto);
	}
	
	public User6DTO findBySeq(String seq) {
		return dao.selectUser6(seq);
	}
	
	public List<User6DTO> findAll() {
		return dao.selectAllUser6();
	}
	
	public void modify(User6DTO dto) {
		dao.updateUser6(dto);
	}
	
	public void delete(String seq) {
		dao.deleteUser6(seq);
	}
}