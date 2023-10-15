package model;
import exceptions.ListIsNullException;
import exceptions.StructureNullException;

public class Agenda<K,V, T extends  Comparable<T>> {

    private HashTable<Integer,Task> table = new HashTable<Integer, Task>(1000);
    private Queue<Task> nonPriorityTasks = new Queue<Task>();
    private Heap<Task> priorityTasks = new Heap<Task>();
    private Stack<Object, Actions> undoStack = new Stack<Object, Actions>();

    private int keyGlobal = 1;

// The `Agenda()` constructor is initializing a new instance of the `Agenda` class. It is adding four
// tasks to the agenda using the `addTasks` method. Each task has a title, description, date, and
// priority. If any of the tasks cannot be added due to a `StructureNullException`, it throws a
// `RuntimeException` with the original exception as the cause.

    public Agenda(){
        try {
            addTasks("task1", "description1", new Date(1,1,1), 1);
            addTasks("task2", "description2", new Date(2,2,2), 2);
            addTasks("task3", "description3", new Date(3,3,3), 3);
            addTasks("task4", "description4", new Date(4,4,4), 2);
        } catch (StructureNullException e) {
            throw new RuntimeException(e);
        }

    }
/**
 * The function returns a string representation of a hash table.
 * 
 * @return The method is returning a string representation of the hashtable.
 */
    public String printHashTable(){
        String msg = table.toString();
        return msg;
    }

/**
 * The function returns a string representation of a non-priority queue.
 * 
 * @return The method is returning a string representation of the nonPriorityTasks.
 */
    public String printNoPriorityQueue(){
        String msg = nonPriorityTasks.toString();
        return msg;
    }

/**
 * The function "printPriorityHeap" returns a string representation of a priority heap.
 * 
 * @return The method is returning a string representation of the priority heap.
 */
    public String printPriorityHeap(){
        String msg = priorityTasks.show();
        return msg;
    }

/**
 * The addTasks function adds a new task to a task management system, either to a priority queue or a
 * non-priority queue, and also updates a hash table with the new task.
 * 
 * @param title The title of the task.
 * @param description The "description" parameter is a String that represents the description of the
 * task. It provides additional details or information about the task.
 * @param date The "date" parameter is of type Date and represents the date of the task.
 * @param priority The priority parameter is an integer value that represents the priority level of the
 * task. A higher priority value indicates a higher priority task.
 * @return The method is returning a boolean value.
 */
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
        return table.insert(taskNode.getKey(), task);
    }

    /**
     * The function modifies a task in a table based on the given parameters and returns a boolean
     * value indicating whether the modification was successful or not.
     * 
     * @param title The title of the task that you want to modify.
     * @param description The description parameter is a String that represents the new description for
     * the task.
     * @param date The "date" parameter is of type Date and represents the new date for the task.
     * @param option The "option" parameter is used to determine which aspect of the task needs to be
     * modified. The possible values for "option" are as follows:
     * @param key The key parameter is an integer value used to determine the position of the task in
     * the hash table.
     * @param priority The priority parameter is an integer that represents the priority level of the
     * task. It can range from 0 (lowest priority) to a higher number (higher priority).
     * @return The method is returning a boolean value.
     */
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
                    Task task = table.searchNode(position).getValue();
                    if (task.getPriority() == 0){

                    }
                    undoStack.push(new Actions(EnumAction.MODIFY4, task));
                    ((Task) table.searchNode(position).getValue()).setPriority(priority);
                    if (nonPriorityTasks.verify((Task) table.searchNode(position).getValue())) {
                        try {
                            removeForModififyNonPriorityTask((Task) table.searchNode(position).getValue());
                        } catch (ListIsNullException e){
                            return false;
                        }
                    } else {
                        removeForModifyPriorityTask((Task) table.searchNode(position).getValue());
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
   /**
    * The function deletes the task with the highest priority from a list and returns a message
    * indicating that the task has been removed.
    * 
    * @return The method is returning a String message.
    */
    public String deletePriority() throws ListIsNullException {
        String msg = "";
        try {
            Task node = priorityTasks.max();
            int idNode = node.getId();
            Task task = (Task)table.search(idNode);

            undoStack.push(new Actions(EnumAction.REMOVE, task));

            table.delete(idNode);
            priorityTasks.extractMax();
            msg += "Task " + node.getTitle() + " has been removed ";
            return msg;
        }catch (ListIsNullException e){
            throw new ListIsNullException("The list is empty");
        }
    }

    /**
     * The function deletes a non-priority task from a table and a queue, and adds the task to an undo
     * stack.
     * 
     * @return The method is returning a String message indicating that a task has been removed.
     */
    public String deleteNoPriority() throws ListIsNullException{
        String msg = "";
        Task nodeNo = nonPriorityTasks.peak();
        int idNodeNo = nodeNo.getId();
        Task taskNo = (Task)table.search(idNodeNo);

        undoStack.push(new Actions(EnumAction.REMOVE, taskNo));

        table.delete(idNodeNo);
        nonPriorityTasks.dequeue();
        msg += "Task " + nodeNo.getTitle() + " has been removed " ;
        return msg;
    }

    /**
     * The function removes a specific task from a non-priority task queue and returns true if the task
     * was successfully removed.
     * 
     * @param task The parameter "task" is of type Task, which represents a task object.
     * @return The method is returning a boolean value.
     */
    public boolean removeForModififyNonPriorityTask (Task task) throws ListIsNullException {
        boolean flag = false;
        try {
            Queue<Task> temporalQueue = new Queue();
            while (!this.nonPriorityTasks.isEmpty()) {
                Task tempElement = (Task) nonPriorityTasks.dequeue();
                if (!tempElement.equals(task)) {
                    temporalQueue.enqueue(tempElement);
                }
            }
            if (temporalQueue.size() == nonPriorityTasks.size()) {
                return flag;
            } else {
                int newsize = temporalQueue.size();
                for (int i = 0; i < newsize; ++i) {
                    this.nonPriorityTasks.enqueue((Task) temporalQueue.dequeue());
                    flag = true;
                }
                return flag;
            }
        } catch (ListIsNullException e) {
            throw new ListIsNullException("The list is empty");
        }
    }


    /**
     * The function removes a specific task from a priority queue and modifies the priority queue
     * accordingly.
     * 
     * @param task The parameter "task" is an object of type Task.
     * @return The method is returning a boolean value.
     */
    public boolean removeForModifyPriorityTask(Task task){
        boolean flag = false;

        Heap<Task> temporalHeap = new Heap<>();
        int sizeListPriority = priorityTasks.size();
        try {
            while (!priorityTasks.isEmpty()) {
                Task element = null;

                element = priorityTasks.extractMax();

                if (!element.equals(task)) {
                    temporalHeap.insert(element.getPriority(), element);
                }
            }
        }catch (ListIsNullException e){
            return false;
        }

        if (temporalHeap.size() == sizeListPriority)
            return false;


        while (!temporalHeap.isEmpty()) {

            Task element = null;
            try {
                element = temporalHeap.extractMax();
                priorityTasks.insert(element.getPriority(), element);

            } catch (ListIsNullException e) {
                throw new RuntimeException(e);
            }
        }
        flag = true;
        return flag;
    }
    public boolean undoMethod () throws ListIsNullException {
        boolean flag = false;

        try{

            Actions action = undoStack.pop();

            Task task = (Task) action.getObject();

            if(action.getAction() == EnumAction.ADD){

              table.delete(task.getId());
                if(task.getPriority() == 0){
                    removeForModififyNonPriorityTask(task);
                }else{
                    removeForModifyPriorityTask(task);
                }

            }else if(action.getAction() == EnumAction.REMOVE){

                table.insert(task.getId(), task);
                if(task.getPriority() == 0){
                    nonPriorityTasks.enqueue(task);
                }else{
                    priorityTasks.insert(task.getPriority(), task);
                }
            }else if (action.getAction() == EnumAction.MODIFY1 || action.getAction() == EnumAction.MODIFY2 || action.getAction() == EnumAction.MODIFY3 || action.getAction() == EnumAction.MODIFY4){

                if (action.getAction() == EnumAction.MODIFY1){

                    modifyTask(action.getTitle(), action.getDescription(), task.getDate(), 1, task.getId(), action.getPriority());

                }else if (action.getAction() == EnumAction.MODIFY2){

                    modifyTask(action.getTitle(), action.getDescription(), task.getDate(), 2, task.getId(), action.getPriority());

                }else if (action.getAction() == EnumAction.MODIFY3){

                    modifyTask(action.getTitle(), action.getDescription(), task.getDate(), 3, task.getId(), action.getPriority());
                }else if (action.getAction() == EnumAction.MODIFY4){

                    modifyTask(action.getTitle(), action.getDescription(), task.getDate(), 4, task.getId(), action.getPriority());
                }

            }
            flag = true;

        }catch (ListIsNullException e){
            throw new ListIsNullException("The list is empty");
        }

        return flag;
    }

   /**
    * The function returns a Heap of Task objects representing priority tasks.
    * 
    * @return The method is returning a Heap of Task objects.
    */
    public Heap<Task> getPriorityTasks() {
        return priorityTasks;
    }
}
