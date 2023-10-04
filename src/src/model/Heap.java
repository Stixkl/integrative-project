package model;

import java.util.ArrayList;

public class Heap<V> implements IPriorityHeap<V>{

    private ArrayList<NodeHeap<V>> A;
    private int heapSize;

    public Heap() {
        A = new ArrayList<>();
        heapSize = 0;
    }

    @Override
    public void insert(int value, V value2) {

    }

    @Override
    public V extractMax() {
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    /*
        public V left(int posicion){
            V izqueirdo = A[((2*(posicion-1))-1)];
            return izqueirdo;
        }

        public T right(int posicion){
            T derecho = A[((2*(posicion-1))+1)];
            return derecho;
        }

         */

    @Override
    public void increaseKey(V value, int newValue) {

    }

}
