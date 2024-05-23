package dao;

import model.ClassRegistration;
import model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDAO {
    private Connection con;

    public InvoiceDAO() {
        con = DAO.con;
    }

    public boolean saveInvoice(Invoice invoice) {
//        try {
//            String query = "INSERT INTO tblInvoice (paymentDate, paymentType, studentID, tblUserid) VALUES (?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
//            ps.setDate(1, new java.sql.Date(invoice.getPaymentDate().getTime()));
//            ps.setString(2, invoice.getPaymentType());
//            ps.setInt(3, invoice.getStudent().getId());
//            ps.setInt(4, invoice.getUser().getId());
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                int invoiceId = getGeneratedInvoiceId(ps);
//                for (ClassRegistration registration : invoice.getListClassRegistration()) {
//                    registration.setInvoice(invoiceId);
//                    saveClassRegistration(registration);
//                }
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }

    private int getGeneratedInvoiceId(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    private boolean saveClassRegistration(ClassRegistration registration) {
//        try {
//            String query = "INSERT INTO tblClassRegistration (registerDate, note, SubjectClassid, Invoiceid) VALUES (?, ?, ?, ?)";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setDate(1, new java.sql.Date(registration.getRegisterDate().getTime()));
//            ps.setString(2, registration.getNote());
//            ps.setInt(3, registration.getSubjectClassId());
//            ps.setInt(4, registration.getInvoiceId());
//
//            int result = ps.executeUpdate();
//            return result > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return false;
    }
}
