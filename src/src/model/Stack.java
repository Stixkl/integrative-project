package model;

import exceptions.ListIsNullException;

public class Stack<K,V> implements IStack<V> {

    private ElementNode<V> top;

    private int size =0;

    public Stack() {
    }

    @Override
    public boolean push( V value){
        ElementNode<V> node = new ElementNode( value);
        boolean flag = false;
        if(top==null){ // lista vacia
            top= node;
            flag = true;
            size++;
        } else {
            node.setNext(top);
            top= node;
            flag = true;
            size++;
        }
        return flag;
    }

    @Override
    public V pop() throws ListIsNullException {
        ElementNode<V> currentTop = top;
        ElementNode<V> currentPointer = top;
        if (currentPointer != null){
            currentPointer = top.getNext();
            top = currentPointer.getNext();
            size--;
            if (top != null){
                top.setPrev(null);
            }
            return currentTop.getValue();
        }
        else {
            throw new exceptions.ListIsNullException("The list is empty");        }
    }
    @Override
    public V Top(){
        return this.top.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    public String toString(){
        String msg = "";
        ElementNode<V> pointer = top;
        while(pointer != null){
            msg += pointer.getValue() + "\n";
            pointer = pointer.getNext();
        }
        return msg;
    }

}