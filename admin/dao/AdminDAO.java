package loveproject.admin.dao;

import loveproject.register.dto.MemberDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class AdminDAO {
	
private Connection con;
	
	public AdminDAO() {
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
	
	public ArrayList<MemberDTO> mainResult(AdminDAO dao, ArrayList<MemberDTO> list){
		String sql = "SELECT id,age,name,gender,area,blackList,good FROM loveProject"; // DB TALBE 명 수정 *****
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO guestDto = new MemberDTO();
				guestDto.setId(rs.getString(1)); 
				guestDto.setAge(rs.getString(2));
				guestDto.setName(rs.getString(3));	
				guestDto.setGender(rs.getString(4));
				guestDto.setArea(rs.getString(5));
				guestDto.setBlacklist(rs.getString(6));
				list.add(guestDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<MemberDTO> resultAll(AdminDAO dao, ArrayList<MemberDTO> list) {
		String sql = "SELECT * FROM loveProject"; // DB TALBE 명 수정 *****
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO guestDto = new MemberDTO();
				guestDto.setId(rs.getString(2)); // DB 위치에 맞게 수정****** 시퀀스num 1번으로 존재
				guestDto.setPw(rs.getString(3));
				guestDto.setName(rs.getString(4));
				guestDto.setAge(rs.getString(5));
				guestDto.setPhone(rs.getString(6));
				guestDto.setGender(rs.getString(7));
				guestDto.setHeight(rs.getString(8));
				guestDto.setArea(rs.getString(9));
				guestDto.setDrink(rs.getString(10));
				guestDto.setMbti(rs.getString(11));
				guestDto.setSmoking(rs.getString(12));
				guestDto.setBloodType(rs.getString(13));
				guestDto.setSelfIntro(rs.getString(14));
				guestDto.setProfile(rs.getString(15));				
				guestDto.setBlacklist(rs.getString(16));
				list.add(guestDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	public MemberDTO result(AdminDAO dao, String id) {
		String sql = "SELECT * FROM loveProject WHERE id = ?"; // DB TALBE 명 수정 *****
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDTO guestDto = new MemberDTO();
				guestDto.setId(rs.getString(2)); // DB 위치에 맞게 수정****** 시퀀스num 1번으로 존재
				guestDto.setPw(rs.getString(3));
				guestDto.setName(rs.getString(4));
				guestDto.setAge(rs.getString(5));
				guestDto.setPhone(rs.getString(6));
				guestDto.setGender(rs.getString(7));
				guestDto.setHeight(rs.getString(8));
				guestDto.setArea(rs.getString(9));
				guestDto.setDrink(rs.getString(10));
				guestDto.setMbti(rs.getString(11));
				guestDto.setSmoking(rs.getString(12));
				guestDto.setBloodType(rs.getString(13));
				guestDto.setSelfIntro(rs.getString(14));
				guestDto.setProfile(rs.getString(15));				
				guestDto.setBlacklist(rs.getString(16));
				return guestDto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public MemberDTO reSelect(MemberDTO guestDto) {
		
		String sql = "UPDATE loveProject set pw = ?, name = ?, age = ?, gender = ?, phone = ?, height = ?, area = ?, bloodtype = ?, mbti = ?, drink = ?, smoking = ?, selfintro = ?  WHERE id =? ";
		PreparedStatement ps;    // DB TALBE 명 수정 *****
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, guestDto.getPw());
			ps.setString(2, guestDto.getName());
			ps.setString(3, guestDto.getAge());
			ps.setString(4, guestDto.getGender());
			ps.setString(5, guestDto.getPhone());
			ps.setString(6, guestDto.getHeight());
			ps.setString(7, guestDto.getArea());
			ps.setString(8, guestDto.getBloodType());
			ps.setString(9, guestDto.getMbti());
			ps.setString(10, guestDto.getDrink());
			ps.setString(11, guestDto.getSmoking());
			ps.setString(12, guestDto.getSelfIntro());
			ps.setString(13, guestDto.getId());	
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return guestDto;
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM loveProject WHERE id =? "; // DB TALBE 명 수정 *****
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);		
			ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}
