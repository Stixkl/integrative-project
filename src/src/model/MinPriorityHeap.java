package model;

public interface MinPriorityHeap {

    public void insert(ElementNode value);
    public ElementNode extractMin();
    public ElementNode Minimum();
    public void decreaseKey(ElementNode value, int newKey);



}
