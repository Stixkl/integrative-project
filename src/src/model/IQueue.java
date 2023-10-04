package model;

public interface IQueue<V> {

    boolean enqueue(V element);

    V dequeue();

    V front();

    boolean isEmpty();
    int size();


}
