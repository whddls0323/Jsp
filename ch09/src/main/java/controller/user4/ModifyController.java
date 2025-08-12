package controller.user4;

import java.io.IOException;

import dto.User4DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User4Service service = User4Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		User4DTO user4DTO = service.findByName(name);	
		
		req.setAttribute("user4DTO", user4DTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user4/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		User4DTO dto = new User4DTO();
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch09/user4/list.do");
	}
}