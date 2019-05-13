package AddTicketServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addServlet")
public class addTickets extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("reimburs_type");
		String amount = request.getParameter("cost");
		Double cost = Double.parseDouble(amount);
		String img = request.getParameter("img");
		String description = request.getParameter("description");
		
		System.out.println("type: " + type);
		System.out.println("cost: " + cost);
		System.out.println("img: " + img);
		System.out.println("description: " + description);
		
		
		
		
		
	}
}
