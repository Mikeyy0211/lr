package dao;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {

    public StudentDAO() {
        super();
    }

    public Student[] searchStudent(String keyword) {
        String sql = "SELECT * FROM tblStudent WHERE fullName LIKE ?";
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFullName(rs.getString("fullName"));
                student.setDob(rs.getDate("dob"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students.toArray(new Student[0]);
    }

    public boolean addStudent(Student student) {
        String sql = "INSERT INTO tblStudent (fullName, dob, phone, email) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getFullName());
            ps.setDate(2, new java.sql.Date(student.getDob().getTime()));
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getEmail());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
