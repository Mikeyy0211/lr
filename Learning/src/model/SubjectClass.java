package model;

import java.io.Serializable;
import java.util.Date;

public class SubjectClass implements Serializable {
    private int id;
    private String name;
    private Date startTime;
    private Date endTime;
    private Program program;

    public SubjectClass() {
        super();
    }

    public SubjectClass(int id, String name, Date startTime, Date endTime, Program program) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.program = program;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
