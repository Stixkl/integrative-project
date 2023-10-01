package model;

public class ElementNode<V> {

    private V value;
    private ElementNode<V> next;
    private ElementNode<V> prev;
    public ElementNode( V value ) {
        this.value = value;
    }
    public ElementNode< V> getPrev() {
        return prev;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public ElementNode<V> getNext() {
        return next;
    }

    public void setNext(ElementNode<V> next) {
        this.next = next;
    }

    public void setPrev(ElementNode<V> prev) {
        this.prev = prev;
    }

}
