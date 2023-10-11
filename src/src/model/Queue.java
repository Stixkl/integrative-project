package model;

import exceptions.ListIsNullException;

public class Queue<V> {

    private ElementNode<V> front;
    private ElementNode<V> rear;

    private int size = 0;

    public Queue() {
    }

    public boolean enqueue(V value) { // inserta un elemento e al final de la queue
        ElementNode<V> node = new ElementNode(value);
        boolean flag = false;
        if (front == null) { // lista vacia
            front = node;
            rear = node;
            size++;
        } else {
            rear.setNext(node);
            node.setPrev(rear);
            rear = node;
            size++;
            flag = true;
        }
        return flag;
    }

    public V dequeue() throws ListIsNullException { // remueve el elemento del frente de la queue
        if (!this.isEmpty()) {
            V frontValue = front.getValue();
            ElementNode<V> nextFront = front.getNext();
            front = nextFront;
            size--;
            if (front != null) {
                front.setPrev(null);
            }
            return frontValue;

        } else {
            throw new ListIsNullException("The list is empty");
        }
    }

    public V peek() {
        return front.getValue();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return this.size;
    }

    public boolean verify(V value) {
        boolean flag = false;
        ElementNode<V> node = front;
        while (node != null && !flag) {
            flag = node.getValue().equals(value);
            node = node.getNext();
        }
        return flag;
    }


    public V get(int index) {
    	ElementNode<V> node = front;
    	int i = 0;
    	while(i!=index) {
    		node = node.getNext();
    		i++;
    	}
    	return node.getValue();
    }

    public String toString(){
        String msg = "";
        ElementNode<V> node = front;
        while(node != null){
            msg += node.getValue().toString() + "\n";
            node = node.getNext();
        }
        return msg;
    }
}

