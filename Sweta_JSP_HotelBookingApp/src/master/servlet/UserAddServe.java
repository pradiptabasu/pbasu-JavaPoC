package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.UserDAO;
import master.DTO.UserDTO;

/**
 * Servlet implementation class UserAddServe
 */
public class UserAddServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String eid=request.getParameter("eid");
		String cphno=request.getParameter("cphno");
		String pass=request.getParameter("pass");
		UserDTO udto=new UserDTO();
		udto.setEid(eid);
		udto.setCphno(cphno);
		udto.setPass(pass);
		UserDAO udao=new UserDAO();
		udao.insertData(udto);
		response.sendRedirect("Login.jsp");
	}

}
