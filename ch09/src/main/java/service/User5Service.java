package service;

import java.util.List;

import dao.User5DAO;
import dto.User5DTO;

public class User5Service {
	private static User5Service instance = new User5Service();
	
	public static User5Service getInstance() {
		return instance;
	}
	
	private User5Service() {};
	
	private User5DAO dao = User5DAO.getInstance();
	
	public void register(User5DTO dto) {
		dao.insertUser5(dto);
	}
	
	public User5DTO findByName(String name) {
		return dao.selectUser5(name);
	}
	
	public List<User5DTO> findAll() {
		return dao.selectAllUser5();
	}
	
	public void modify(User5DTO dto) {
		dao.updateUser5(dto);
	}
	
	public void delete(String name) {
		dao.deleteUser5(name);
	}
}