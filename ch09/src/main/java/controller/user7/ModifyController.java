package controller.user7;

import java.io.IOException;

import dto.User7DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User7Service;

@WebServlet("/user7/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User7Service service = User7Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		User7DTO user7DTO = service.findById(id);
		
		req.setAttribute("user7DTO", user7DTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user7/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		
		User7DTO dto = new User7DTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);	
		
		service.modify(dto);
		
		resp.sendRedirect("/ch09/user7/list.do");
	}
}