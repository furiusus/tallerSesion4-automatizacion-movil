package dao;

import java.sql.Time;
import java.util.Date;

public class TaskWhendo {
    private String title;
    private String notes;
    private String date;
    private String time;
    private String repeat;
    private String remember;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "TaskWhendo{" +
                "title='" + title + '\'' +
                ", notes='" + notes + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", repeat='" + repeat + '\'' +
                ", remember='" + remember + '\'' +
                '}';
    }
}
