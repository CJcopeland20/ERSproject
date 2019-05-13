package ERS;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/pastServlet")
public class pastServlet extends DefaultServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("---service---");
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Origin", "*");
		super.service(request, response);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		ObjectMapper om = new ObjectMapper();
        ERSDao dao = new ERSDao();
        dao.connect();
		System.out.println(ERSDao.CurrentId);
		
		ArrayList tickets;
		try {
			tickets = dao.ViewPastTicket(ERSDao.CurrentId);
			System.out.println(tickets);
			om.writeValue(response.getOutputStream(), tickets);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
