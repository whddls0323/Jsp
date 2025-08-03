package controller.user3;

import java.io.IOException;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User3Service service = User3Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user3/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String age = req.getParameter("age");
		
		User3DTO dto = new User3DTO();
		dto.setUser_id(user_id);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAge(age);
		
		service.register(dto);
		
		resp.sendRedirect("/ch09/user3/list.do");
	}
}
