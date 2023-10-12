package model;

import exceptions.ListIsNullException;
import exceptions.StructureNullException;

public class Agenda<K,V, T extends  Comparable<T>> {

    private HashTable<Integer,Task> table = new HashTable<Integer, Task>(1000);
    private Queue<Task> nonPriorityTasks = new Queue<Task>();
    private Heap<Task> priorityTasks = new Heap<Task>();

    private Stack<Object, Actions> undoStack = new Stack<Object, Actions>();

    private int keyGlobal = 1;

    public Agenda(){
        try {
            addTasks("tarea1", "descripcion1", new Date(1,1,1), 1);
            addTasks("tarea2", "descripcion2", new Date(2,2,2), 2);
            addTasks("tarea3", "descripcion3", new Date(3,3,3), 3);
            addTasks("tarea4", "descripcion4", new Date(4,4,4), 2);
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

        Actions action = new Actions(EnumAction.ADD, task);

        undoStack.push(action);

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
                case 1:undoStack.push(new Actions(EnumAction.MODIFY1, table.searchNode(position).getValue()));
                    ((Task) table.searchNode(position).getValue()).setTitle(title);
                    flag = true;
                    break;
                case 2:
                    undoStack.push(new Actions(EnumAction.MODIFY2, table.searchNode(position).getValue()));
                    ((Task) table.searchNode(position).getValue()).setDescription(description);
                    flag = true;
                    break;
                case 3:
                    undoStack.push(new Actions(EnumAction.MODIFY3, table.searchNode(position).getValue()));
                    ((Task) table.searchNode(position).getValue()).setDate(date);
                    flag = true;
                    break;
                case 4:
                    undoStack.push(new Actions(EnumAction.MODIFY4, table.searchNode(position).getValue()));
                    ((Task) table.searchNode(position).getValue()).setPriority(priority);
                    if (nonPriorityTasks.verify((Task) table.searchNode(position).getValue())) {
                        try {
                            removeNonPriorityTask((Task) table.searchNode(position).getValue());
                        } catch (ListIsNullException e){
                            return false;
                        }
                    } else {
                        priorityTasks.remove((Task) table.searchNode(position).getValue()); // aca se esta haciendo el metodo remove de priorityTasks ESTA MALOOOOO
                    }
                    if (priority == 0) {
                        nonPriorityTasks.enqueue((Task) table.searchNode(position).getValue());
                    } else {
                        priorityTasks.insert(priority,(Task) table.searchNode(position).getValue());
                    }
                    flag = true;
                    break;
            }
        }
        return flag;
    }
    public String removePriority(){
        String msg = "";
        Task node = priorityTasks.max();
        int idNode = node.getId();
        Task task = (Task)table.search(idNode);

        undoStack.push(new Actions(EnumAction.REMOVE, task));

        table.delete(idNode);
        priorityTasks.extractMax();
        msg += "Task " + node.getTitle() + " has been removed ";
        return msg;
    }

    public String removeNoPriority() throws ListIsNullException{
        String msg = "";
        Task nodeNo = nonPriorityTasks.peek();
        int idNodeNo = nodeNo.getId();
        Task taskNo = (Task)table.search(idNodeNo);

        undoStack.push(new Actions(EnumAction.REMOVE, taskNo));

        table.delete(idNodeNo);
        nonPriorityTasks.dequeue();
        msg += "Task " + nodeNo.getTitle() + " has been removed " ;
        return msg;
    }

    public boolean removeNonPriorityTask (Task task) throws ListIsNullException {
        boolean flag = false;
        try {
            Queue<Task> temp = new Queue();
            while (!this.nonPriorityTasks.isEmpty()) {
                Task tempElement = (Task) nonPriorityTasks.dequeue();
                if (!tempElement.equals(task)) {
                    temp.enqueue(tempElement);
                }
            }
            if (temp.size() == nonPriorityTasks.size()) {
                return flag;
            } else {
                int newsize = temp.size();
                for (int i = 0; i < newsize; ++i) {
                    this.nonPriorityTasks.enqueue((Task) temp.dequeue());
                    flag = true;
                }
                return flag;
            }
        } catch (ListIsNullException e) {
            throw new ListIsNullException("The list is empty");
        }
    }
    public boolean undoMethod () throws ListIsNullException {
        boolean flag = false;

        try{

            Actions action = undoStack.pop();

            Task task = (Task) action.getObject();

            if(action.getAction() == EnumAction.ADD){

              table.delete(task.getId());
                if(task.getPriority() == 0){
                    nonPriorityTasks.dequeue(); // esto esta mal
                }else{
                    priorityTasks.extractMax(); // esto esta mal
                }

            }else if(action.getAction() == EnumAction.REMOVE){

                table.insert(task.getId(), task);
                if(task.getPriority() == 0){
                    nonPriorityTasks.enqueue(task);
                }else{
                    priorityTasks.insert(task.getPriority(), task);
                }
            }else if (action.getAction() == EnumAction.MODIFY1 && action.getAction() == EnumAction.MODIFY2 && action.getAction() == EnumAction.MODIFY3 && action.getAction() == EnumAction.MODIFY4){

                if (action.getAction() == EnumAction.MODIFY1){

                    modifyTask(task.getTitle(), task.getDescription(), task.getDate(), 1, task.getId(), task.getPriority());

                }else if (action.getAction() == EnumAction.MODIFY2){

                    modifyTask(task.getTitle(), task.getDescription(), task.getDate(), 2, task.getId(), task.getPriority());

                }else if (action.getAction() == EnumAction.MODIFY3){

                    modifyTask(task.getTitle(), task.getDescription(), task.getDate(), 3, task.getId(), task.getPriority());
                }else if (action.getAction() == EnumAction.MODIFY4){

                    modifyTask(task.getTitle(), task.getDescription(), task.getDate(), 4, task.getId(), task.getPriority());
                }



                /**Task task = (Task) action.getObject();
                table.delete(task.getId());
                if(task.getPriority() == 0){
                    nonPriorityTasks.dequeue(); // esto esta mal hay que cambiar la forma de hacer el remove
                }else{
                    priorityTasks.remove(task); // esto esta mal hay que cambiar la forma de hacer el remove
                }
                table.insert(task.getId(), task);
                if(task.getPriority() == 0){
                    nonPriorityTasks.enqueue(task);
                }else{
                    priorityTasks.insert(task.getPriority(), task);
                }**/
            }
            flag = true;

        }catch (ListIsNullException e){
            throw new ListIsNullException("The list is empty");
        }

        return flag;
    }

    public Heap<Task> getPriorityTasks() {
        return priorityTasks;
    }
}
