package model;

import java.io.Serializable;
import java.util.Date;

public class SubjectClass implements Serializable {
    private int id;
    private String name;
    private Date startTime;
    private Date endTime;
    private int programId;

    public SubjectClass() {
        super();
    }

    public SubjectClass(String name, Date startTime, Date endTime, int programId) {
        super();
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.programId = programId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }
}
