package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.HotelDAO;
import master.DTO.HotelDTO;

/**
 * Servlet implementation class HotelMenu_FindServlet
 */
public class HotelMenu_FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String hloc=request.getParameter("hloc");
		HotelDTO hdto=new HotelDTO();
		hdto.setHloc(hloc);
		HotelDAO hdao=new HotelDAO();
		
		//hdao.getHotelData(hdto,hloc);
		if(hloc.equalsIgnoreCase("KOLKATA"))
			response.sendRedirect("Kolkata.jsp");
		else if (hloc.equalsIgnoreCase("smThingElse"))
			response.sendRedirect("smThingElse.jsp");
	}

}
