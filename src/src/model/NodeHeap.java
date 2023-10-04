package model;

public class NodeHeap<T> {

    private int priority;

    private T node;

    public NodeHeap(int priority, T node) {
        this.priority = priority;
        this.node = node;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }
}
