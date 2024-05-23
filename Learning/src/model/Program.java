package model;

import java.io.Serializable;

public class Program implements Serializable {
    private int id;
    private String name;
    private String type;
    private String description;
    private Level level;

    public Program() {
        super();
    }

    public Program(int id, String name, String type, String description, Level level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.level = level;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
