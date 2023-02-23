package Planner;

import java.sql.Timestamp;

public class Task extends Milestone{
    private final Timestamp deadline;

    public Task(Timestamp start, String name, Timestamp deadline) {
        super(start, name);
        this.deadline = deadline;
    }

    @Override
    public Timestamp getEndMoment() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task " + start + " – " + getEndMoment() + " " + name + " " + notification;
    }
}
