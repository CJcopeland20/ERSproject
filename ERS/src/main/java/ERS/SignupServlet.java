package ERS;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/signupServlet")
public class SignupServlet extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
         
        System.out.println("username: " + username);
        System.out.println("First name: " + firstname);
        System.out.println("Last name: " + lastname);
        System.out.println("Email: " + email);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "<br/>";       
        htmlRespone += "Your first name is: " + firstname + "<br/>";
        htmlRespone += "Your last name is: " + lastname + "<br/>";
        htmlRespone += "Your email is: " + email + "</h2>";
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);
         
    }
 
}