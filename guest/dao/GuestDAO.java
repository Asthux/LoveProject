package loveproject.guest.dao;

import loveproject.register.dto.MemberDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class GuestDAO {
	private Connection con;
	public GuestDAO() {
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
	public ArrayList<MemberDTO> manInfo(GuestDAO dao, ArrayList<MemberDTO> list) {
		String sql = "select * from (select id,name,age,height,area,good from loveProject where gender = '여' order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				String good = rs.getString("good");
				list.add(new MemberDTO());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public ArrayList<MemberDTO> womanInfo(GuestDAO dao, ArrayList<MemberDTO> list) {
		String sql = "select * from (select id,name,age,height,area from loveProject where gender = '남' order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				list.add(new MemberDTO());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public ArrayList<MemberDTO> manInfo(MemberDTO dto, ArrayList<MemberDTO> list) {
		String sql = "select * from (select id,name,age,height,area from loveProject where gender = '여' order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				list.add(new MemberDTO());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public ArrayList<MemberDTO> womanInfo(MemberDTO dto, ArrayList<MemberDTO> list) {
		String sql = "select * from (select id,name,age,height,area from loveProject where gender = '남' order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				list.add(new MemberDTO());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
		
	public MemberDTO selectId(String id) {
		String sql = "SELECT * FROM loveProject WHERE id = ?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString(2), rs.getString(3), rs.getString(4),
                		rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                		rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                		rs.getString(16));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
public MemberDTO modify(MemberDTO dto) {
		
		String sql = "UPDATE loveProject SET pw=?,age=?,area=?,mbti=?,height=?,drink=?,smoking=?,name=?,phone=? WHERE id =?";
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getAge());
			ps.setString(3, dto.getArea());
			ps.setString(4, dto.getMbti());
			ps.setString(5, dto.getHeight());
			ps.setString(6, dto.getDrink());	
			ps.setString(7, dto.getSmoking());
			ps.setString(8, dto.getName());
			ps.setString(9, dto.getPhone());
			ps.setString(10, dto.getId());	
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public ArrayList<MemberDTO> GenderInfo(String gender, ArrayList<MemberDTO> list){
		String sql = "select * from (select id,name,age,height,area from loveProject where gender = ? order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, gender);
			rs=ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				list.add(new MemberDTO());
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
	}
	public ArrayList<MemberDTO> showInfo(GuestDAO dao, ArrayList<MemberDTO> list) {
		String sql = "select * from (select id,name,age,height,area from loveProject order by DBMS_RANDOM.VALUE) where rownum<10";
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String height = rs.getString("height");
				String area = rs.getString("area");
				list.add(new MemberDTO());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
