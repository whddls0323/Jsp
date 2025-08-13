package controller.customer;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//뷰 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String custid = req.getParameter("custid");
		
		CustomerDTO customerDTO = service.findById(custid);
		
		if(customerDTO != null) {
			//회원일 경우(세션처리)
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", customerDTO);
			
			//이동
			resp.sendRedirect("/shopApp/product/list.do?login=success");
		} else {
			//회원이 아니면 상품 목록 이동
			resp.sendRedirect("/shopApp/product/list.do?login=fail");
		}
	}
}
