package ERS;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/addServlet")
public class addServlet extends DefaultServlet{
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Origin", "*");
		super.service(request, response);
	}
	
	
	@Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
        addBean ab = om.readValue(request.getInputStream(), addBean.class);
        
		try {
			Add(ab.getId(), ab.getCost(), ab.getDate(), 
					 ab.getDescription(), ab.getType());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
         
    }
		
		protected void Add(int id, Double cost, String date,
				 String description, int type) throws SQLException {
			ERSDao dao = new ERSDao();
			dao.connect();
			dao.AddTicket(id, cost, date, description, type);
			
		}
	

}
