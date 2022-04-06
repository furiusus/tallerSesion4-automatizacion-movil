package dao;

public class TaskWhendoResult extends TaskWhendo{
    private String daysLeft;

    public String getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public String toString() {
        return "TaskWhendoResult{" +
                "title='" + this.getTitle() + '\'' +
                ", notes='" + this.getNotes() + '\'' +
                ", date='" + this.getDate() + '\'' +
                ", time='" + this.getTime() + '\'' +
                ", repeat='" + this.getRepeat() + '\'' +
                ", remember='" + this.getRemember() + '\'' +
                "daysLeft='" + daysLeft + '\'' +
                '}';
    }
}
