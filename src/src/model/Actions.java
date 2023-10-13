package model;

    public class Actions {

        private EnumAction action;

        private Task task;

        public Actions(EnumAction action, Task task) {

            this.action = action;

            this.task = task;

        }

    public EnumAction getAction() {
        return action;
    }

    public Task getObject() {
        return task;
    }
}
