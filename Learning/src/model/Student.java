package model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private int id;
    private String fullName;
    private Date dob;
    private String phone;
    private String email;

    public Student() {
        super();
    }

    public Student(String fullName, Date dob, String phone, String email) {
        super();
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
