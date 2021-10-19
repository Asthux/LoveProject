package loveproject.register.dao;

import loveproject.register.dto.MemberDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDAO {
	private Connection con;

    public RegisterDAO() {
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

    public MemberDTO selectId(String id) {
        String sql = "SELECT * FROM loveProject WHERE id = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                MemberDTO dto = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                		rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
                		rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
/*
 * num number
  private String id;
	private String pw;
	private String name;
	private String age;
	private String phone;
	private String gender;
	private String height;
	private String area;
	private String drink;
	private String mbti;
	private String smoking;
	private String bloodType;
	private String selfIntro;
	private String profile;
 */
    public int insert(MemberDTO dto) {
        String sql = "INSERT INTO loveProject VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPw());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getAge());
            ps.setString(5, dto.getPhone());
            ps.setString(6, dto.getGender());
            ps.setString(7, dto.getHeight());
            ps.setString(8, dto.getArea());
            ps.setString(9, dto.getDrink());
            ps.setString(10, dto.getMbti());
            ps.setString(11, dto.getSmoking());
            ps.setString(12, dto.getBloodType());
            ps.setString(13, dto.getSelfIntro());
            ps.setString(14, dto.getProfile());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
