package model;

import java.util.ArrayList;

public class Heap<V> implements IPriorityHeap<V>{

    private ArrayList<NodeHeap<V>> A;

    public Heap() {
        A = new ArrayList<>();
        A.add(null);
    }

    @Override
    public void insert(int value, V value2) {
        A.add(new NodeHeap(value, value2));
        buildMaxHeapify();
    }

    public void buildMaxHeapify() {
        for(int i= A.size()-1; i >= 1;i--){
            maxHeapify(i);
        }
    }

    @Override
    public V extractMax() {
        if(A.size() < 1) {
            // Aqui va la excepcion en lugar de imprimir
            System.out.println("heap underflow");
        }
        NodeHeap<V> max = A.get(0);
        A.set(0, A.get(A.size()-1));
        A.remove(A.size()-1);
        maxHeapify(0);
        return max.getNode();
    }

    @Override
    public V max() {
        return A.get(0).getNode();
    }

    public void heapSort(){
        buildMaxHeapify();
        for(int i= A.size()-1; i >=1;i--){
            NodeHeap<V> temp = A.get(0);
            maxHeapify(0);
            A.set(i,temp);
        }
    }

    @Override
    public void increaseKey(V value, int newValue) {
        int index = -1;
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).getNode().equals(value)){
                index = i;
            }
        }
        if(index != -1){
            A.get(index).setPriority(newValue);
            while(index > 0 && A.get(parent(index)).getPriority() < A.get(index).getPriority()){
                NodeHeap<V> temp1= A.get(index);
                NodeHeap<V> temp2= A.get(parent(index));
                A.set(index,temp2);
                A.set(parent(index),temp1);
                index = parent(index);
            }
        }
    }

    public String show() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            msg.append(A.get(i).getNode().toString()).append("\n");
        }
        return msg.toString();
    }

    public V search(V node){
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).getNode().equals(node)){
                return A.get(i).getNode();
            }
        }
        return null;
    }

    public boolean delete(V node){
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).getNode().equals(node)){
                A.remove(i);
                buildMaxHeapify();
                return true;
            }
        }
        return false;
    }
    private int parent(int index) {
        return index/2;
    }

    public Heap<V> clone(){
        Heap<V> clone = new Heap<>();
        for (int i = 0; i < A.size(); i++) {
            clone.insert(A.get(i).getPriority(),A.get(i).getNode());
        }
        return clone;
    }

    public void maxHeapify(int index) {

        int l = 2*index;
        int r = 2*index + 1;
        int largest;
        if((l <= A.size() -1 && A.get(l).getPriority() > A.get(index).getPriority()) && A.get(l)!=null && A.get(index) != null) {
            largest = l;
        } else {
            largest = index;
        }
        if((r <= A.size() - 1 && A.get(r).getPriority()  > A.get(largest).getPriority()) && A.get(r)!=null && A.get(largest) != null) {
            largest = r;
        }
        if(largest != index) {
            NodeHeap<V> temp1= A.get(index);
            NodeHeap<V> temp2= A.get(largest);
            A.set(index,temp2);
            A.set(largest,temp1);
            maxHeapify(largest);
        }
    }

    private void exchange(int i, int largest) {
        NodeHeap<V> temp1= A.get(i);
        NodeHeap<V> temp2= A.get(largest);
        A.set(i,temp2);
        A.set(largest,temp1);
    }

}
