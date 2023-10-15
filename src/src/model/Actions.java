package model;

    public class Actions {

        private EnumAction action;

        private Task task;

        private int priority;

        private String title;

        private String description;

// The code snippet `public Actions(EnumAction action, Task task)` is a constructor for the `Actions`
// class. It takes two parameters, `action` of type `EnumAction` and `task` of type `Task`.
        public Actions(EnumAction action, Task task) {

            this.action = action;

            this.task = task;

            this.priority = task.getPriority();

            this.title = task.getTitle();

            this.description = task.getDescription();

        }

    /**
     * The function returns an EnumAction object.
     * 
     * @return The method is returning an EnumAction object.
     */
    public EnumAction getAction() {
        return action;
    }

    /**
     * The function returns an object of type Task.
     * 
     * @return The method is returning an object of type Task.
     */
    public Task getObject() {
        return task;
    }

    public int getPriority(){
        return this.priority;
    }
    public String getTitle(){
        return this.title;
    }

        public String getDescription() {
            return description;
        }
    }
