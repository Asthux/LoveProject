package loveproject.login.dao;

import loveproject.login.dto.LoginDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	private Connection con;

    public LoginDAO() {
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

    public LoginDTO selectId(String id) {
        String sql = "SELECT * FROM loveProject WHERE id = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                LoginDTO dto = new LoginDTO(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                		rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16) , rs.getString(17));
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
