package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Invoice implements Serializable {
    private int id;
    private Date paymentDate;
    private String paymentType;
    private Student student;
    private User user;
    private List<ClassRegistration> listClassRegistration;

    public Invoice() {
        super();
    }

    public Invoice(int id, Date paymentDate, String paymentType, Student student, User user, List<ClassRegistration> listClassRegistration) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.student = student;
        this.user = user;
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

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ClassRegistration> getListClassRegistration() {
        return listClassRegistration;
    }

    public void setListClassRegistration(List<ClassRegistration> listClassRegistration) {
        this.listClassRegistration = listClassRegistration;
    }
}
