package ers2;

import java.applet.*;
import java.sql.*;

public class ViewTickets extends Applet {

	private static final String url = "jdbc:postgresql://cj.cadnhummvpel.us-east-2.rds.amazonaws.com:5432/ersproject1";
	private static final String login = "copelchr20";
	private static final String pas = "caboose1996";
	private static Connection c = null;
	
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


	protected static void ShowAccounts() throws SQLException{
		Connection c = DriverManager.getConnection(url,login,pas);
	
		PreparedStatement stmt = c.prepareStatement("select * from reimburs_type");
		ResultSet rs = stmt.executeQuery();
		System.out.println("Type ID  |  Type Name ");
		while(rs.next()) {
			int reimb_id = rs.getInt("reimb_type_id");
			String reimb_type = rs.getString("reimb_type");
			System.out.println(reimb_id + "  |  " + reimb_type + "   ");
		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		ShowAccounts();
	}
}