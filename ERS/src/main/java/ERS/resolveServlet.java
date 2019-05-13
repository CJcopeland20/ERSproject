package ERS;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;



public class resolveServlet extends DefaultServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("---service---");
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Origin", "*");
		super.service(request, response);
	}
	
	@Override
	public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		ObjectMapper om = new ObjectMapper();
        resolveBean rb = om.readValue(request.getInputStream(), resolveBean.class);
        ERSDao dao = new ERSDao();
        dao.connect();
		System.out.println("Current ID: " + ERSDao.CurrentId);
		if(rb.getStatus()==2) {
			try {
				dao.ApproveTicket(ERSDao.CurrentId, rb.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (rb.getStatus()==3) {
			try {
				dao.DenyTicket(ERSDao.CurrentId, rb.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
		
}
