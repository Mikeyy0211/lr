package dao;

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
                program.setLevelId(rs.getInt("Levelid"));
                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programs.toArray(new Program[0]);
    }
}
