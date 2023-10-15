package model;

    public class Actions {

        private EnumAction action;

        private Task task;

// The code snippet `public Actions(EnumAction action, Task task)` is a constructor for the `Actions`
// class. It takes two parameters, `action` of type `EnumAction` and `task` of type `Task`.
        public Actions(EnumAction action, Task task) {

            this.action = action;

            this.task = task;

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
}
