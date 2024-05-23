package dao;

import model.ClassRegistration;
import model.Invoice;

import java.sql.*;

public class InvoiceDAO {
    private Connection con;

    public InvoiceDAO() {
        con = DAO.con;
    }

    public boolean saveInvoice(Invoice invoice) {
        try {
            String query = "INSERT INTO tblInvoice (paymentDate, paymentType, studentID, tblUserid) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(invoice.getPaymentDate().getTime()));
            ps.setString(2, invoice.getPaymentType());
            ps.setInt(3, invoice.getStudent().getId());
            ps.setInt(4, invoice.getUser().getId());

            int result = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (result > 0) {
                invoice.setId(rs.getInt(1));
                for (ClassRegistration registration : invoice.getListClassRegistration()) {
                    saveClassRegistration(registration, invoice.getId());
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean saveClassRegistration(ClassRegistration registration, int invoiceID) {
        try {
            String query = "INSERT INTO tblClassRegistration (registerDate, note, SubjectClassid, Invoiceid) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(registration.getRegisterDate().getTime()));
            ps.setString(2, registration.getNote());
            ps.setInt(3, registration.getSubjectClass().getId());
            ps.setInt(4, invoiceID);

            int result = ps.executeUpdate();
            if (result > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                registration.setId(rs.getInt(1));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
