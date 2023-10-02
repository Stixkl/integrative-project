package model;

public class Stack<K,V> implements IStack<V> {

    private ElementNode<V> top;

    public Stack() {
        ElementNode<V> elementNode = new ElementNode<V>(null);
    }

    @Override
    public void push( V value){
        ElementNode<V> elementNode = new ElementNode<V>( value);
        if(top==null){ // lista vacia
            top= elementNode;
        } else {
            elementNode.setNext(top);
            top= elementNode;
        }
    }
    @Override
    public V pop(){
        ElementNode<V> currentPointer = top;
        if (currentPointer != null){
            top = currentPointer.getNext();
            return currentPointer.getValue();
        }
        else {
            return null;
        }
    }
    @Override
    public V getTop(){
        return this.top.getValue();
    }




}