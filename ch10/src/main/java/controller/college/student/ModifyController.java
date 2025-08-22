package controller.college.student;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.college.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = StudentService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stdNo = req.getParameter("stdNo");
		StudentDTO studentDTO = service.findById(stdNo);
		
		req.setAttribute("studentDTO", studentDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/college/student/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stdNo = req.getParameter("stdNo");
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String major = req.getParameter("major");
		String enr_date = req.getParameter("enr_date");
		
		StudentDTO dto = new StudentDTO();
		dto.setStdNo(stdNo);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setMajor(major);
		dto.setEnr_date(enr_date);
		
		logger.info(dto.toString());
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/college/student/list.do");
	}
}
