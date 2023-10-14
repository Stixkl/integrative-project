package model;

public class Task implements Comparable<Task> {

    int id;
    private String title;
    private String description;
    private Date date;
    private int priority;
// The code you provided is a constructor for the Task class. It is used to create a new Task object
// with the specified parameters.

    public Task(int id, String title, String description, Date date, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

/**
 * The getTitle() function returns the title of an object.
 * 
 * @return The method is returning the value of the variable "title".
 */
    public String getTitle() {
        return title;
    }

/**
 * The function sets the title of an object.
 * 
 * @param title The title parameter is a String that represents the new title for an object.
 */
    public void setTitle(String title) {
        this.title = title;
    }

/**
 * The getDescription() function returns the description of an object.
 * 
 * @return The method is returning the value of the variable "description".
 */
    public String getDescription() {
        return description;
    }

/**
 * The function sets the description of an object.
 * 
 * @param description The parameter "description" is a String that represents the description of an
 * object.
 */
    public void setDescription(String description) {
        this.description = description;
    }

/**
 * The function returns a Date object.
 * 
 * @return The method is returning a Date object.
 */
    public Date getDate() {
        return date;
    }

/**
 * The function sets the value of the "date" variable to the specified Date object.
 * 
 * @param date The parameter "date" is of type "Date".
 */
    public void setDate(Date date) {
        this.date = date;
    }

/**
 * The function returns the value of the id variable.
 * 
 * @return The method is returning the value of the variable "id".
 */
    public int getId() {
        return id;
    }

/**
 * The function sets the value of the "id" variable.
 * 
 * @param id The parameter "id" is an integer value that represents the ID of an object.
 */
    public void setId(int id) {
        this.id = id;
    }

/**
 * The function returns the priority value.
 * 
 * @return The method is returning the value of the variable "priority".
 */
    public int getPriority() {
        return priority;
    }

/**
 * The function sets the priority of an object.
 * 
 * @param priority The priority parameter is an integer value that represents the priority level of an
 * object or task.
 */
    public void setPriority(int priority) {
        this.priority = priority;
    }

/**
 * The toString() function returns a string representation of an object's title, id, and priority.
 * 
 * @return The toString() method is returning a string representation of an object. The returned string
 * includes the title, id, and priority of the object.
 */
    @Override
    public String toString() {
        return "Title: " + title + " " + "Id: " + id + " " + "Priority: " + priority;
    }

/**
 * The compareTo function compares the dates of two Task objects.
 * 
 * @param o The parameter "o" is an object of the class "Task".
 * @return The method is returning the result of comparing the dates of two tasks.
 */
    @Override
    public int compareTo(Task o) {
        return this.getDate().compareDates(this.getDate(), o.getDate());
    }
}
