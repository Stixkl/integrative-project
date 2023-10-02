package model;

public class Heap<T extends Comparable<T>> {

    private T[] A;
    private int heapSize;

    public T left(int posicion){
        T izqueirdo = A[((2*(posicion-1))-1)];
        return izqueirdo;
    }

    public T right(int posicion){
        T derecho = A[((2*(posicion-1))+1)];
        return derecho;
    }






}
