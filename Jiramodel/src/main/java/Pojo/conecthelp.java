package Pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conecthelp {
	
	String url;
	String username;
	String password;
	public  Connection  getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return con ;
		
	}
	public conecthelp(String url, String username,String password) {
		//super();
		this.url = "jdbc:mysql://localhost:3306/Jira_detail?characterEncoding=latin1&useConfigs=maxPerformance";
		this.username = "root";
		this.password = "Sudhar234@";
	}
	public conecthelp() {
		this.url = "jdbc:mysql://localhost:3306/Jira_detail?characterEncoding=latin1&useConfigs=maxPerformance";
		this.username = "root";
		this.password = "Sudhar234@";

	}
	
}
