package loveproject.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import loveproject.admin.dto.AdminMatchingDTO;

public class AdminMatchingDAO {

	private Connection con;
	
	public AdminMatchingDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<AdminMatchingDTO> matchingresult(AdminMatchingDAO dao, ArrayList<AdminMatchingDTO> list) {
		String sql = "SELECT name1,name2,day,accept FROM project2";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				AdminMatchingDTO guestManaDto = new AdminMatchingDTO();
				guestManaDto.setName1(rs.getString(1));
				guestManaDto.setName2(rs.getString(2));
				guestManaDto.setDay(rs.getString(3));
				guestManaDto.setAccept(rs.getString(4));		
				list.add(guestManaDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
