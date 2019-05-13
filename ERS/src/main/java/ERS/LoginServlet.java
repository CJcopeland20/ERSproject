package ERS;

import java.io.IOException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
 
@WebServlet("/loginServlet")
public class LoginServlet extends DefaultServlet {
	
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
        loginBean lb = om.readValue(request.getInputStream(), loginBean.class);

        System.out.println("Start");
        System.out.println("user: " + lb.getUsername());
        System.out.println("pass: " + lb.getPassword());
        // do some processing here...
        String hashPassword = null;
		try {
			String hashPass = Hashing(lb.getPassword());
			hashPassword = hashPass;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("hash password: " + hashPassword);
		
		try {
			System.out.println("trying pass");
			lb = Verify(lb.getUsername(), hashPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cache = lb.getId() + " " + lb.getUsername() + " " + lb.getFirst_name() + " " + lb.getLast_name() + " " + lb.getRole();
		
		HttpSession session = request.getSession(true);
		session.setAttribute("id", lb.getId());
		//session.setAttribute("role", role);
		om.writeValue(response.getOutputStream(),cache);
		        
    }
		
	protected String Hashing(String password) throws NoSuchAlgorithmException {
		String generatedPassword = null;
		
    	// Create MessageDigest instance for MD5
    	MessageDigest md = MessageDigest.getInstance("MD5");
    	//Add password bytes to digest
    	md.update(password.getBytes());
    	//Get the hash's bytes 
    	byte[] bytes = md.digest();
    	//This bytes[] has bytes in decimal format;
    	//Convert it to hexadecimal format
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i< bytes.length ;i++)
    	{
    		sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    	}
    	return generatedPassword = sb.toString();
	}

	protected loginBean Verify(String username, String hashPassword) throws SQLException, NoSuchAlgorithmException {
		
		ERSDao dao = new ERSDao();
		dao.connect();
		loginBean lb = dao.LoginVerification(username, hashPassword);
		return lb;
    	}
		
	
 
}