package service;

import java.util.List;

import dao.User7DAO;
import dto.User7DTO;

public class User7Service {
	private static User7Service instance = new User7Service();
	
	public static User7Service getInstance() {
		return instance;
	}
	
	private User7Service() {};
	
	private User7DAO dao = User7DAO.getInstance();
	
	public void register(User7DTO dto) {
		dao.insertUser7(dto);
	}
	
	public User7DTO findById(String id) {
		return dao.selectUser7(id);
	}
	
	public List<User7DTO> findAll() {
		return dao.selectAllUser7();
	}
	
	public void modify(User7DTO dto) {
		dao.updateUser7(dto);
	}
	
	public void delete(String id) {
		dao.deleteUser7(id);
	}
}