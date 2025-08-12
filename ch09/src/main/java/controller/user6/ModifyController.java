package controller.user6;

import java.io.IOException;

import dto.User6DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User6Service;

@WebServlet("/user6/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User6Service service = User6Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		
		User6DTO user6DTO = service.findBySeq(seq);
		
		req.setAttribute("user6DTO", user6DTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user6/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		User6DTO dto = new User6DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch09/user6/list.do");
	}
}