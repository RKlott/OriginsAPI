package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
	
	private static Connection connection;
	private static String url_base = "jdbc:mysql://", host = " ", 
			username = " ", passeword = " ";
	
	public static Connection getConnection(){
		return connection;
	}
	
	public static boolean isConnected(){
		try {
			if((connection == null) || (connection.isClosed())){
				return false;
			}else{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void connection(){
		if(!isConnected()){
			try {
				connection = DriverManager.getConnection(url_base+host, username, passeword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void deconnection(){
		if(isConnected()){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
