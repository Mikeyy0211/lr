package dao;

import model.Level;
import model.Program;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO extends DAO {

    public ProgramDAO() {
        super();
    }

    public Program[] searchProgram(String keyword) {
        String sql = "SELECT * FROM tblProgram WHERE name LIKE ?";
        String sql2 = "SELECT * FROM tblLevel WHERE ID = ?";
        List<Program> programs = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Program program = new Program();
                program.setId(rs.getInt("id"));
                program.setName(rs.getString("name"));
                program.setType(rs.getString("type"));
                program.setDescription(rs.getString("description"));

                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt("Levelid"));

                ResultSet rs2 = ps2.executeQuery();
                Level level = new Level(
                        rs2.getInt("id"),
                        rs2.getString("name"),
                        rs2.getString("description")
                );


                program.setLevel(level);
                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs.toArray(new Program[0]);
    }
}
