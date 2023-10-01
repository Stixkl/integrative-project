package model;

public interface IQueue<V> {

    public void enqueue( V element);

    public  V dequeue();

    public V front();

    public boolean isEmpty();

}
