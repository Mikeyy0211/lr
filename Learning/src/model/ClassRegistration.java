package model;

import java.io.Serializable;
import java.util.Date;

public class ClassRegistration implements Serializable {
    private int id;
    private Date registerDate;
    private String note;
    private SubjectClass subjectClass;

    public ClassRegistration() {
        super();
    }

    public ClassRegistration(int id, Date registerDate, String note, SubjectClass subjectClass) {
        this.id = id;
        this.registerDate = registerDate;
        this.note = note;
        this.subjectClass = subjectClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SubjectClass getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(SubjectClass subjectClass) {
        this.subjectClass = subjectClass;
    }
}
