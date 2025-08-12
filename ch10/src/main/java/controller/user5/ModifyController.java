package controller.user5;

import java.io.IOException;

import dto.User4DTO;
import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User5Service service = User5Service.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		User5DTO user5DTO = service.findById(seq);
		
		req.setAttribute("user5DTO", user5DTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user5/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String addr = req.getParameter("addr");
		
		User5DTO dto = new User5DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddr(addr);
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/user5/list.do");
	}
}
