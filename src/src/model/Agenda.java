package model;

public class Agenda<K,V, T extends  Comparable<T>> {
    private HashTable<Integer,Task> table = new HashTable<Integer, Task>(100);
    private Queue<Task> nonPriorityTasks = new Queue<Task>();
    private Heap<Task> priorityTasks = new Heap<Task>();

    private int keyGlobal = 1;

    public Agenda(){
        addTasks("tarea1", "descripcion1", new Date(1,1,1), 1);
        addTasks("tarea2", "descripcion2", new Date(2,2,2), 2);
        addTasks("tarea3", "descripcion3", new Date(3,3,3), 3);
    }

    public String printHashTable(){
        String msg = "";
        for(int i = 0; i < table.getSize() ; i++){
            // Table[i] != null
            // Exception null pointer table
            if(table.search(i) != null){
                msg += table.search(i).getId() + " " + table.search(i).getTitle() + "\n";
            }
        }
        return msg;
    }
    public String printHHH(){
        String msg = table.toString();
        return msg;
    }

    public String printPriorityQueue(){
        String msg = "";
        msg= ""+priorityTasks.max();
        return msg;
    }


    public boolean addTasks(String title, String description, Date date, int priority) {
        Task task = new Task(keyGlobal,title, description, date,priority);
        if(priority==4){
            nonPriorityTasks.enqueue(task);
        }else{
            priorityTasks.insert(priority, task);
        }
        HashNode<Integer,Task> taskNode = (HashNode<Integer, Task>) new HashNode<Integer, Task>(keyGlobal, task);
        keyGlobal++;
        // falta que se agregue al stack de undo
        // falta excepciones
        return table.insert(taskNode.getKey(), task);
    }

    public boolean addReminder(String title, String description, Date date) {
        boolean flag = false;

        return flag;
    }

    public boolean modifyTask(String title, String description, Date date, int option, int key, int priority) {
        boolean flag = false;

        int position = table.hashFunction(key);
        if (table.searchNode(position).getValue() != null){
            switch (option){
                case 1:
                    ((Task)table.searchNode(position).getValue()).setTitle(title);
                    flag = true;
                    break;
                case 2:
                    ((Task)table.searchNode(position).getValue()).setDescription(description);
                    flag = true;
                    break;
                case 3:
                    ((Task)table.searchNode(position).getValue()).setDate(date);
                    flag = true;
                    break;
                case 4:
                    ((Task)table.searchNode(position).getValue()).setPriority(priority);
                    if () {

                    }
                    flag = true;
                    break;
            }
        }
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
