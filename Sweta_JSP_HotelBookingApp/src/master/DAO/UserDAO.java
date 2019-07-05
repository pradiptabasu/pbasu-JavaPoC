package master.DAO;
import java.sql.*;

import master.DTO.UserDTO;
import master.utilities.ConnectionFactory;
public class UserDAO {
Connection cn;
PreparedStatement ps=null;
ResultSet  rs=null;
Statement st=null;
String insert_sql="insert into USER_DTLS values(?,?,?)";
String delete_sql="delete from USER_DTLS where MAILID=? ";
String update_sql="update USER_DTLS  set PHNO=? where MAILID=? ";
String select_sql="select * from USER_DTLS";
String check_sql="select * from USER_DTLS where MAILID=? and PASSWORD=?";
public void insertData(UserDTO udto) {
	
	try {
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		ps=cn.prepareStatement(insert_sql);
		ps.setString(1, udto.getEid());
		ps.setString(2, udto.getCphno());
		ps.setString(3, udto.getPass());
		ps.executeUpdate();
		cn.commit();  
		
	}
	catch (SQLException se) {
		// TODO: handle exception
		se.printStackTrace();
	}
}

public boolean checkData(UserDTO udto) {
	boolean match=false;
	try {
		ConnectionFactory con=new ConnectionFactory();
		cn=con.getConn();
		st=cn.createStatement();
		rs=st.executeQuery("select * from USER_DTLS where MAILID='"+udto.getEid()+"' and PASSWORD='"+udto.getPass()+"'");
	    match=rs.next();

	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return match;

	
}

}
