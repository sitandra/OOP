package Planner;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar<T extends Milestone> {
    List<T> milestones = new ArrayList<>();

    public MyCalendar(List<T> milestones) {
        this.milestones = milestones;
    }

    public MyCalendar(){}

    public void add(T milestone) {
        milestones.add(milestone);
    }

    public void remove(T milestone) {
        milestones.remove(milestone);
    }

    public void export(String filePath) {
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(this.toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder ms = new StringBuilder();
        for (T milestone : milestones) {
            ms.append(milestone).append("\n");
        }
        return "MyCalendar:\n" + ms + "\n";
    }
}
