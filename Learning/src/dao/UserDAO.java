package dao;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection con;

    public UserDAO() {
        con = DAO.con;
    }

    public User checkLogin(User user) {
        try {
            String query = "SELECT * FROM tblUser WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User loggedInUser = new User();
                loggedInUser.setId(rs.getInt("id"));
                loggedInUser.setUsername(rs.getString("username"));
                loggedInUser.setPassword(rs.getString("password"));
                loggedInUser.setFullName(rs.getString("fullName"));
                loggedInUser.setRole(rs.getString("role"));
                return loggedInUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
