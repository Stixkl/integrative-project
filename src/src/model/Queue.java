package model;

public class Queue<V> {

    private ElementNode<V> front;
    private ElementNode<V> rear;

    public void enqueue(V value){
        ElementNode<V> node = new ElementNode<V>(value);
        if(front==null){ // lista vacia
            front=node;
        } else {
            rear.setNext(node);
        }
        rear=node;
    }

    public ElementNode<V> dequeue(){
        ElementNode<V> currentFront = front;
        front = front.getNext();
        return currentFront;
    }

    public V peak(){
        return front.getValue();
    }
}

