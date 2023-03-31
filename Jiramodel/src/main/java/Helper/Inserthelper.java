package Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Pojo.Jira;
import Pojo.conecthelp;

public class Inserthelper {

	public static boolean register(String firstname, String lastname, String mobileno, String email, String password) {
		boolean result = false;
		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement prepst = con.prepareStatement(
					"insert into Userdetails(Firstname,Lastname,Mobileno,email,passwordd) values(?,?,?,?,?)");
			prepst.setString(1, firstname);
			prepst.setString(2, lastname);
			prepst.setString(3, mobileno);
			prepst.setString(4, email);
			prepst.setString(5, password);

			int row = prepst.executeUpdate();
			if (row > 0)
				result = true;

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public static String loginhelp(String email, String Password) {
		// boolean result = false;
		String result = "";
		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement prepst = con
					.prepareStatement("select * from Userdetails where email =? and passwordd =?");

			prepst.setString(1, email);
			prepst.setString(2, Password);
			ResultSet rs = prepst.executeQuery();
			while (rs.next()) {
				result = rs.getString(2);
				break;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	public static boolean createticket(String Assignee, String Reporter, String Heading, String Status, String Notify) {

		boolean result = false;
		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement prepst = con.prepareStatement(
					"insert into Newtickets(Assignee,Reporter,Heading,Notify,Statusto) values(?,?,?,?,?)");
			prepst.setString(1, Assignee);
			prepst.setString(2, Reporter);
			prepst.setString(3, Heading);
			prepst.setString(4, Notify);
			prepst.setString(5, Status);

			int row = prepst.executeUpdate();
			if (row > 0)
				result = true;

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<Jira> viewticket(ArrayList<Jira> al) {
		// ArrayList<Jira> al = new ArrayList<Jira>();

		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			Statement statement = con.createStatement();

			ResultSet rs = statement.executeQuery("select * from Newtickets");
			Jira jira1 = null;
			while (rs.next()) {
				jira1 = new Jira(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				al.add(jira1);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return al;
	}

	public static boolean DeleteTicket(int id) {
		boolean result = false;
		// String uname = "";
		Connection con = null;
		try {

			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement pt = con.prepareStatement("delete from Newtickets where Ticketid= ?");

			pt.setInt(1, id);

			int i = pt.executeUpdate();

			while (i > 0) {

				result = true;
				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<String> ViewUser(ArrayList<String> al) {

		String result = "";
		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Userdetails");

			while (rs.next()) {
				al.add(rs.getString(5));

			}

			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return al;
	}

	public static ArrayList<Jira> EditOneticket(int id) {
		ArrayList<Jira> a1 = new ArrayList<Jira>();

		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement prt = con.prepareStatement("select * from Newtickets where Ticketid=?");
			prt.setInt(1, id);
			ResultSet rs = prt.executeQuery();
			Jira j1 = null;
			while (rs.next()) {
				j1 = new Jira(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				a1.add(j1);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a1;
	}

	public static boolean Update(String assignee, String reporter, String heading, String notify, String status, int id) {
		
		
		boolean result = false;
		Connection con = null;
		try {
			conecthelp hel = new conecthelp();
			con = hel.getConnection();
			PreparedStatement prepst = con.prepareStatement("update Newtickets set Assignee=?,Reporter=?,Heading=?,Notify=?,Statusto=? where Ticketid=?");
			prepst.setString(1, assignee);
			prepst.setString(2, reporter);
			prepst.setString(3, heading);
			prepst.setString(4, notify);
			prepst.setString(5, status);
			prepst.setInt(6, id);

			int row = prepst.executeUpdate();
			while (row > 0) {
				result = true;
				break;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
  
		
  		
		
	}
}