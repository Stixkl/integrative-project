package model;

public interface IPriorityHeap<K> {

    void insert(int value, K value2);
    K extractMax();
    K max();
    void increaseKey(K value, int newValue);



}
