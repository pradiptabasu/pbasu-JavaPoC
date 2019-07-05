package master.DAO;
import java.sql.*;
import java.util.ArrayList;

import master.DTO.HotelDTO;
import master.DTO.UserDTO;
import master.utilities.ConnectionFactory;
public class HotelDAO {
	Connection cn;
	PreparedStatement ps=null;
	ResultSet  rs=null;
	Statement st=null;
	String insert_sql="insert into HOTEL_MASTER values(?,?,?)";
	String delete_sql="delete from HOTEL_MASTER where HID=? ";
	String update_sql="update HOTEL_MASTER  set HNAME=? where HID=? ";
	String select_sql="select * from HOTEL_MASTER";
	String check_sql="select HNAME, HPRICE from HOTEL_MASTER where HLOC=?";
	
	public ArrayList getHotelData(HotelDTO hdto, String location) {
		System.out.println("in getHotelData");
		ArrayList arr=new ArrayList();
		try {
			 ConnectionFactory con=new ConnectionFactory();
			 cn=con.getConn();
			 //st=cn.createStatement();
			 ps = cn.prepareStatement(check_sql);
			 ps.setString(1,location);
			 //rs=st.executeQuery(check_sql);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 HotelDTO hdto1=new HotelDTO();
				 hdto1.setHname(rs.getString(1));
				 hdto1.setHprice(rs.getString(2));
				 arr.add(hdto1);
				 
				 
			 }
			
		}
		catch (SQLException se) {
			// TODO: handle exception
			se.printStackTrace();
		}
		return arr;
		
	}

}
