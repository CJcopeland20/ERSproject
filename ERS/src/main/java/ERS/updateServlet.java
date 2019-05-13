package ERS;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

public class updateServlet extends DefaultServlet {

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
		System.out.println("Current ID: " + ERSDao.CurrentId);
		
		ArrayList tickets;
		try {
			tickets = dao.ManageTicket(ERSDao.CurrentId);
			System.out.println(tickets);
			om.writeValue(response.getOutputStream(), tickets);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
