package model;

import exceptions.ListIsNullException;

public interface IPriorityHeap<K> {

    void insert(int value, K value2);
    K extractMax() throws ListIsNullException;
    K max();
    void increaseKey(K value, int newValue);



}
