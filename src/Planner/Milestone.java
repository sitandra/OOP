package Planner;

import java.sql.Timestamp;

public abstract class Milestone {
    protected Timestamp start;
    protected String name;
    protected String description;
    protected boolean notification = true;

    public Milestone(Timestamp start, String name) {
        this.start = start;
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Milestone notificationOn() {
        notification = true;
        return this;
    }

    public Milestone notificationOff() {
        notification = false;
        return this;
    }

    public abstract Timestamp getEndMoment();
}
