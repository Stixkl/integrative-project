package model;

import exceptions.ListIsNullException;

public interface IStack<V> {

    boolean push(V value);

    V pop() throws ListIsNullException;

    V Top();

    int size();

    boolean isEmpty();






}
