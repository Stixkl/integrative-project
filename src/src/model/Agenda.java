package model;

import exceptions.ListIsNullException;
import exceptions.StructureNullException;

public class Agenda<K,V, T extends  Comparable<T>> {
    private HashTable<Integer,Task> table = new HashTable<Integer, Task>(1000);
    private Queue<Task> nonPriorityTasks = new Queue<Task>();
    private Heap<Task> priorityTasks = new Heap<Task>();

    private int keyGlobal = 1;

    public Agenda(){
        try {
            addTasks("tarea1", "descripcion1", new Date(1,1,1), 1);
            addTasks("tarea2", "descripcion2", new Date(2,2,2), 2);
            addTasks("tarea3", "descripcion3", new Date(3,3,3), 3);
        } catch (StructureNullException e) {
            throw new RuntimeException(e);
        }

    }
    public String printHashTable(){
        String msg = table.toString();
        return msg;
    }

    public String printNoPriorityQueue(){
        String msg = nonPriorityTasks.toString();
        return msg;
    }

    public String printPriorityHeap(){
        String msg = priorityTasks.show();
        return msg;
    }

    public boolean addTasks(String title, String description, Date date, int priority) throws StructureNullException {
        Task task = new Task(keyGlobal,title, description, date,priority);
        if(priority==0){
            nonPriorityTasks.enqueue(task);
        }else{
            priorityTasks.insert(priority, task);
            getPriorityTasks().buildMaxHeapify();
        }
        HashNode<Integer,Task> taskNode = (HashNode<Integer, Task>) new HashNode<Integer, Task>(keyGlobal, task);
        keyGlobal++;
        // falta que se agregue al stack de undo
        // falta excepciones
        return table.insert(taskNode.getKey(), task);
    }

    public boolean modifyTask(String title, String description, Date date, int option, int key, int priority) {
        boolean flag = false;

        int position = table.hashFunction(key);
        if (table.searchNode(position).getValue() != null) {
            switch (option) {
                case 1:
                    ((Task) table.searchNode(position).getValue()).setTitle(title);
                    flag = true;
                    break;
                case 2:
                    ((Task) table.searchNode(position).getValue()).setDescription(description);
                    flag = true;
                    break;
                case 3:
                    ((Task) table.searchNode(position).getValue()).setDate(date);
                    flag = true;
                    break;
                case 4:
                    ((Task) table.searchNode(position).getValue()).setPriority(priority);
                    if (nonPriorityTasks.verify((Task) table.searchNode(position).getValue())) {
                        try {
                            removeNonPriorityTask((Task) table.searchNode(position).getValue());
                        } catch (ListIsNullException e){
                            return false;
                        }
                    } else {
                        priorityTasks.delete((Task) table.searchNode(position).getValue());

                    }
                    if (priority == 0) {
                        nonPriorityTasks.enqueue((Task) table.searchNode(position).getValue());
                    } else {
                        priorityTasks.insert(priority, (Task) table.searchNode(position).getValue());
                    }
                    flag = true;

                    break;
                // Cambiar de queue a heap
                // Cambiar de heap a queue
                // Eliminar donde estaba
                // Agregar donde va
                //verifique si esta dentro de priority o nonpriority y lo elimine de ahi y lo agregue al otro
            }
            priorityTasks.buildMaxHeapify();


        }

        return flag;
    }


    public boolean removeGeneral(Integer id){
        boolean flag = false;

        Task task = (Task)table.search(id);
        flag = true;
        return flag;

    }


    public boolean removeNonPriorityTask (Task task) throws ListIsNullException {
        try {
            Queue<Task> temp = new Queue();

            while (!this.nonPriorityTasks.isEmpty()) {
                Task tempElement = (Task) nonPriorityTasks.dequeue();
                if (!tempElement.equals(task)) {
                    temp.enqueue(tempElement);
                }
            }

            if (temp.size() == nonPriorityTasks.size()) {
                return false;
            } else {
                int newsize = temp.size();

                for (int i = 0; i < newsize; ++i) {
                    this.nonPriorityTasks.enqueue((Task) temp.dequeue());
                }

                return true;
            }
        } catch (ListIsNullException e) {
            throw new ListIsNullException();
        }
    }

    public boolean undoMethod () {
        boolean flag = false;

        // utiliza un stack para hacer un metodo de deshacer


        return flag;
    }

    public Heap<Task> getPriorityTasks() {
        return priorityTasks;
    }
}
