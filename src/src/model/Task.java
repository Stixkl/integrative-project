package model;

public class Task implements Comparable<Task> {

    int id;
    private String title;
    private String description;
    private Date date;
    private int priority;

    public Task(int id, String title, String description, Date date, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Title: " + title + " " + "Id: " + id + " " + "Priority: " + priority;
    }

    @Override
    public int compareTo(Task o) {
        return this.getDate().compareDates(this.getDate(), o.getDate());
    }
}
