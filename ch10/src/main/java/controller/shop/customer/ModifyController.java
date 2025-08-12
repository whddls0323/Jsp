package controller.shop.customer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;

@WebServlet("/shop/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service = CustomerService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		CustomerDTO customerDTO = service.findById(cid);
		
		req.setAttribute("customerDTO", customerDTO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/shop/customer/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		String name = req.getParameter("name");
		String hp = req.getParameter("hp");
		String address = req.getParameter("address");
		String rdate = req.getParameter("rdate");
		
		CustomerDTO dto = new CustomerDTO();
		dto.setCid(cid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAddress(address);
		dto.setRdate(rdate);
		
		logger.info(dto.toString());
		
		service.modify(dto);
		
		resp.sendRedirect("/ch10/shop/customer/list.do");
	}
}