package dao;

import model.ClassRegistration;
import java.sql.*;

public class ClassRegistrationDAO extends DAO {

    public ClassRegistrationDAO() {
        super();
    }

//    public boolean saveClassRegistration(ClassRegistration classRegistration) {
//        String sql = "INSERT INTO tblClassRegistration (registerDate, note, SubjectClassid, Invoiceid) VALUES (?, ?, ?, ?)";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setDate(1, new java.sql.Date(classRegistration.getRegisterDate().getTime()));
//            ps.setString(2, classRegistration.getNote());
//            ps.setInt(3, classRegistration.getSubjectClass().getId());
//            ps.setInt(4, classRegistration.get);
//            int result = ps.executeUpdate();
//            return result > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
