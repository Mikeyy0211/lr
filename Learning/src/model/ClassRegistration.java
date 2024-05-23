package model;

import java.io.Serializable;
import java.util.Date;

public class ClassRegistration implements Serializable {
    private int id;
    private Date registerDate;
    private String note;
    private int subjectClassId;
    private int invoiceId;

    public ClassRegistration() {
        super();
    }

    public ClassRegistration(Date registerDate, String note, int subjectClassId, int invoiceId) {
        this.registerDate = registerDate;
        this.note = note;
        this.subjectClassId = subjectClassId;
        this.invoiceId = invoiceId;
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

    public int getSubjectClassId() {
        return subjectClassId;
    }

    public void setSubjectClassId(int subjectClassId) {
        this.subjectClassId = subjectClassId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
}
