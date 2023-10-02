package model;

import java.util.ArrayList;

public class Agenda<K,V, T extends  Comparable<T>> {
    private HashTable<Integer,Task> table;
    private int keyGlobal = 1;
    private ArrayList<Task> taskList;


    public Agenda(){
        table = new HashTable<Integer, Task>(999);
        taskList = new ArrayList<Task>();
    }


    public String printHashTable(){
        String msg = "";
        msg= ""+table.searchNode(1);
        return msg;
    }
    public boolean addTasks(String title, String description, Date date) {
        Task task = new Task(title, description, date);
        HashNode<Integer,Task> taskNode = (HashNode<Integer, Task>) new HashNode<Integer, Task>(keyGlobal, task);
        keyGlobal++;
        taskList.add(task);
        return table.insert(taskNode.getKey(), task);
    }

    public void insertionSortNoPriority() {
        for (int i = 0; i < taskList.size() ; i++) {
            int j = i-1;
            Task current = taskList.get(i);
            while(j>=0 && current.getDate().compareDates(current.getDate(), taskList.get(j).getDate()) < 0){
                taskList.set(j+1, taskList.get(j));
                --j;
            }
            taskList.set(j+1, current);
        }
    }

    public String printTaskList() {
        String msg = "";
        for (int i = 0; i < taskList.size(); i++) {
            msg += i+1+"." + taskList.get(i).getTitle() + "\n";
        }
        return msg;
    }
    public String printTaskListAtributtes() {
        String msg = "";
        for (int i = 0; i < taskList.size(); i++) {
            msg += i+1+"." + taskList.get(i).getTitle() + "\n";
        }
        return msg;
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
