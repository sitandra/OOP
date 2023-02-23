package Planner;

import java.sql.Timestamp;

public class Reminder extends Milestone {
    public Reminder(Timestamp start, String name) {
        super(start, name);
    }

    @Override
    public Timestamp getEndMoment() {
        return start;
    }

    @Override
    public String toString() {
        return "Reminder " + start + " " + name + " " + notification;
    }
}
