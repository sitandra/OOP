package Planner;

import java.sql.Timestamp;

public class Meet extends Milestone{
    private final int duration; // sec

    public Meet(Timestamp start, String name, int duration) {
        super(start, name);
        this.duration = duration;
    }

    @Override
    public Timestamp getEndMoment() {
        return new Timestamp(start.getTime() + (duration * 1000L));
    }

    @Override
    public String toString() {
        return "Meet " + start + " – " + getEndMoment() + " " + name + " " + notification;
    }
}
