package model;

public class Agenda<K,V> {
    private HashTable<String,Task> table;
    public Agenda(){
    }
    public boolean addTasks(String title, String description, Date date) {
        Task task = new Task(title, description, date);
        HashNode<K,V> taskNode = (HashNode<K, V>) new HashNode<Object, Task>(null,task);
        table.insert(taskNode.getKey(), task);
        return true;
    }
    public boolean addReminder(String title, String description, Date date) {
        boolean flag = false;

        return flag;
    }

    public boolean modifyTask() {
        boolean flag = false;
        return flag;
    }

    public boolean modifyReminder() {
        boolean flag = false;
        return flag;
    }

    public boolean deleteReminder() {
        boolean flag = false;
        return flag;
    }

    public boolean deleteTask() {
        boolean flag = false;
        return flag;
    }

    public boolean undoMethod() {
        boolean flag = false;

        return flag;
    }
}
