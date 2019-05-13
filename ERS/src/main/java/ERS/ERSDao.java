package ERS;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ERSDao {

	protected static final String url = System.getenv("aws_url");
	protected static final String login = System.getenv("aws_login");
	protected static final String pas = System.getenv("aws_password");
	protected static Connection c = null;
	public static int CurrentId;
	
	protected Connection connect() {
		Connection c1 = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			c1 = DriverManager.getConnection(url, login, pas);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("try again");
		}
		c = c1;
		System.out.println("---Opened database successfully---");
		return c;
	}


	protected loginBean LoginVerification(String user, String pass) 
			throws SQLException, NoSuchAlgorithmException{
		
		Connection c = DriverManager.getConnection(url,login,pas);
    
     	
    	PreparedStatement stmt = c.prepareStatement("SELECT * FROM ers_users WHERE ers_username =? and ers_password =?;");
    	stmt.setString(1, user);
    	stmt.setString(2, pass);	
    	ResultSet rs = stmt.executeQuery();
    	rs.next();
    	int id = rs.getInt("ers_users_id");
		String first_name = rs.getString("user_firstname");
		String last_name = rs.getString("user_lastname");
		String email = rs.getString("user_email");
		int role = rs.getInt("user_role_id");
		System.out.println("Login Complete!");
		CurrentId = id;
	
		return new loginBean(id, user, pass, first_name, last_name, email, role);
    		
	}

	
	protected void AddTicket(int user_id, Double cost, String date,
			 String description, int type) throws SQLException {
		Connection c = DriverManager.getConnection(url,login,pas);

		PreparedStatement stmt = c.prepareStatement("Insert into ers_tickets (reimb_amount, reimb_submitted,"
				+ "reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id,"
				+ "reimb_type_id) values (?,?,null,?,?,null,1,?);");
		stmt.setDouble(1, cost);
		stmt.setString(2, date);
		stmt.setString(3, description);
		stmt.setInt(4, user_id);
		stmt.setInt(5, type);
		stmt.executeUpdate();
		System.out.println("---entry added successfully---");
		
	}
	
	protected ArrayList ViewPastTicket(int id) throws SQLException {
		Connection c = DriverManager.getConnection(url,login,pas);
		
		ArrayList<ticketBean> tickets = new ArrayList<ticketBean>();
		PreparedStatement stmt = c.prepareStatement("select * from ers_tickets where reimb_author = ?; ");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			ticketBean tb = new ticketBean();
			tb.setId(rs.getInt("reimb_id"));
			tb.setCost(rs.getDouble("reimb_amount"));
			tb.setSubmitted(rs.getString("reimb_submitted"));
			tb.setResolved(rs.getString("reimb_resolved"));
			tb.setDescription(rs.getString("reimb_description"));
			tb.setAuthor(rs.getInt("reimb_author"));
			tb.setResolver(rs.getInt("reimb_resolver"));
			tb.setStatus(rs.getInt("reimb_status_id")); 
			tb.setType(rs.getInt("reimb_type_id"));
			tickets.add(tb);
		}
		return tickets;	

	}
	
	protected ArrayList ManageTicket(int id) throws SQLException {
		Connection c = DriverManager.getConnection(url,login,pas);
		
		ArrayList<updateBean> manage = new ArrayList<updateBean>();
		PreparedStatement stmt = c.prepareStatement("select * from ers_tickets where not reimb_author = ?; ");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			updateBean ub = new updateBean();
			ub.setId(rs.getInt("reimb_id"));
			ub.setCost(rs.getDouble("reimb_amount"));
			ub.setSubmitted(rs.getString("reimb_submitted"));
			ub.setDescription(rs.getString("reimb_description"));
			ub.setAuthor(rs.getInt("reimb_author"));
			ub.setStatus(rs.getInt("reimb_status_id")); 
			ub.setType(rs.getInt("reimb_type_id"));
			manage.add(ub);
		}
		return manage;	

	}


	protected void ApproveTicket(int user_id, int id) throws SQLException {
		Connection c = DriverManager.getConnection(url,login,pas);
		
		PreparedStatement stmt = c.prepareStatement("Update ers_tickets set reimb_status_id=2, reimb_resolved= current_timestamp"
				+ ", reimb_resolver=? where reimb_id=?");
		stmt.setInt(1, user_id);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		System.out.println("Update successful");
	}
	
	protected void DenyTicket(int user_id, int id) throws SQLException {
		Connection c = DriverManager.getConnection(url,login,pas);
		
		PreparedStatement stmt = c.prepareStatement("Update ers_tickets set reimb_status_id=3, reimb_resolved= current_timestamp"
				+ ", reimb_resolver=? where reimb_id=?");
		stmt.setInt(1, user_id);
		stmt.setInt(2, id);
		stmt.executeUpdate();
		System.out.println("Update successful");
	}
	
}
