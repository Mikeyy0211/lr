package dao;

import model.SubjectClass;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectClassDAO extends DAO {

    public SubjectClassDAO() {
        super();
    }

    public SubjectClass[] searchAvailableSubjectClass(int programId) {
        String sql = "SELECT * FROM tblSubjectClass WHERE Programid = ?";
        List<SubjectClass> classes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, programId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SubjectClass subjectClass = new SubjectClass();
                subjectClass.setId(rs.getInt("id"));
                subjectClass.setName(rs.getString("name"));
                subjectClass.setStartTime(rs.getTimestamp("startTime"));
                subjectClass.setEndTime(rs.getTimestamp("endTime"));
                subjectClass.setProgramId(rs.getInt("Programid"));
                classes.add(subjectClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes.toArray(new SubjectClass[0]);
    }
}
