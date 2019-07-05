package master.utilities;
import java.sql.*;
public class ConnectionFactory {
Connection cn=null;
public Connection getConn() {
	// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/pocdb","PL","PL");
		
	}
	catch(ClassNotFoundException ce)
	{
		ce.printStackTrace();
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
		
	}
	
	
	return cn;
	

}
}
