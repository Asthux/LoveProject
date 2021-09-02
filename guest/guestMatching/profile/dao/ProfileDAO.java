package loveproject.guest.profile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import loveproject.guest.profile.dto.ProfileDTO;

public class ProfileDAO {
private Connection con;
	
	public ProfileDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password ="oracle";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProfileDTO selectId(String id) {
		String sql = "SELECT * FROM loveProject WHERE id = ?";
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				ProfileDTO dto = new ProfileDTO(rs.getString(2), rs.getString(3), rs.getString(4),
                		rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                		rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                		rs.getString(16), rs.getString(17));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// matchingDB에서 상대를 특정하고 listForm에 넣는 기능
	public ArrayList<ProfileDTO> inputInfo(String loginid, ArrayList<ProfileDTO> list) {
		
		String sql = "select id1 from project2 where id2 = ? and accept = '수락'";
		PreparedStatement ps;
		ResultSet rs, rs2;
		String sql2 = "select id,name,age,height,area from loveProject where id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id1 = rs.getString(1);
				System.out.println(id1);
				try {
					ps = con.prepareStatement(sql2);
					ps.setString(1, id1);
					rs2 = ps.executeQuery();
					if(rs2.next()) {
						String id = rs2.getString("id");
						String name = rs2.getString("name");
						String age = rs2.getString("age");
						String height = rs2.getString("height");
						String area = rs2.getString("area");
						list.add(new ProfileDTO(id,name,age,height,area));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 매칭DB에 기록이 있는지 확인하고 기록 남기기, 반대기록을 검색해서 값을 반환
	public String matching(String loginid, String id) {
		String sql;
		PreparedStatement ps;
		ResultSet rs;
		String id1, id2;
		String logid = "";
		ProfileDTO dto1 = selectId(loginid);
		ProfileDTO dto2 = selectId(id);
		String loginname = dto1.getName();
		String name = dto2.getName();
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String day = format.format(time);
		
		// 요청한 대상인지 매칭성사가 되었는지 확인
		sql = "SELECT id2 FROM project2 WHERE id1 = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginid);
			rs = ps.executeQuery();
			while(rs.next()) {
				logid = rs.getString(1);
				System.out.println(logid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(logid.equals(id)) {
			sql = "select * from project2 where id1 = ? and id2 = ? and accept = '수락'";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, loginid);
				rs = ps.executeQuery();
				while(rs.next()) {
					id1 = rs.getString(1);
					id2 = rs.getString(2);
					if(id1.equals(id) && id2.equals(loginid)) {
						ProfileDAO dao = new ProfileDAO();
						ProfileDTO dto = dao.selectId(id);
						String phone = dto.getPhone();
						String msg = "매칭이 성사되었습니다.\n상대의 연락처"+phone+"으로 연락하세요.";
						return msg;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "이미 매칭요청한 대상입니다.";
		}
		
		
		// 요청한 대상이 아닐 경우 db에 기록, 상대방도 요청이 있었다면 매칭 성사
		sql = "insert into project2 values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, id);
			ps.setString(3, loginname);
			ps.setString(4, name);
			ps.setString(5, day);
			ps.setString(6, "거절");
			ps.executeUpdate();
			
			sql = "select * from project2 where id1 = ? and id2 = ? and accept = '수락'";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, loginid);
				rs = ps.executeQuery();
				while(rs.next()) {
					id1 = rs.getString(1);
					id2 = rs.getString(2);
					if(id1.equals(id) && id2.equals(loginid)) {
						ProfileDAO dao = new ProfileDAO();
						ProfileDTO dto = dao.selectId(id);
						String phone = dto.getPhone();
						String msg = "매칭이 성사되었습니다.\n상대의 연락처"+phone+"으로 연락하세요.";
						return msg;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "매칭요청을 보냈습니다.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 매칭취소 기능
	public String nomatch(String loginid, String id) {
		ProfileDTO dto = selectId(loginid);
		ProfileDTO dto2 = selectId(id);
		String loginname = dto.getName();
		String name = dto2.getName();
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String day = format.format(time);
		String sql;
		PreparedStatement ps;
		sql = "insert into project2 values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginid);
			ps.setString(2, id);
			ps.setString(3, loginname);
			ps.setString(4, name);
			ps.setString(5, day);
			ps.setString(6, "거절");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "매칭을 거절했습니다.";
	}
	
}
