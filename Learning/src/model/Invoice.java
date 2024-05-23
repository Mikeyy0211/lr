package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Invoice implements Serializable {
    private int id;
    private Date paymentDate;
    private String paymentType;
    private int studentID;
    private int tblUserid;
    private List<ClassRegistration> listClassRegistration;

    public Invoice() {
        super();
    }

    public Invoice(Date paymentDate, String paymentType, int studentID, int tblUserid, List<ClassRegistration> listClassRegistration) {
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.studentID = studentID;
        this.tblUserid = tblUserid;
        this.listClassRegistration = listClassRegistration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getTblUserid() {
        return tblUserid;
    }

    public void setTblUserid(int tblUserid) {
        this.tblUserid = tblUserid;
    }

    public List<ClassRegistration> getListClassRegistration() {
        return listClassRegistration;
    }

    public void setListClassRegistration(List<ClassRegistration> listClassRegistration) {
        this.listClassRegistration = listClassRegistration;
    }
}
