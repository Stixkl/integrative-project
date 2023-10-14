package model;

import exceptions.ListIsNullException;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class Heap<V> implements IPriorityHeap<V>{

    private ArrayList<NodeHeap<V>> A;

    public Heap() {
        A = new ArrayList<>();
    }

    @Override
    public boolean insert(int value, V value2) {
        if(value2 == null){
            return false;
        } else {
            A.add(new NodeHeap(value, value2));
            buildMaxHeapify();
            return true;
        }
    }

    public NodeHeap<V> get(int index){
        return A.get(index);
    }

    public boolean isEmpty() {
        return A.size() == 0;
    }

    public int size(){
        return A.size();
    }

    public boolean remove(V node) {
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).getNode().equals(node)){
                A.remove(i);
                buildMaxHeapify();
                return true;
            }
        }
        return false;
    }

    @Override
    public V extractMax()  throws ListIsNullException {
        if(A.isEmpty()) {
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

    private int parent(int index) {
        return index/2;
    }

    public void buildMaxHeapify() {
        for(int i= A.size()-1; i >= 0;i--){
            maxHeapify(i);
        }
    }

    public void maxHeapify(int index) {
        int l = 2*index;
        int r = 2*index + 1;
        int masGrande;
        if((l <= A.size() - 1 && A.get(l).getPriority() > A.get(index).getPriority())) {
            masGrande = l;
        } else {
            masGrande = index;
        }
        if((r <= A.size() -1 && A.get(r).getPriority()  > A.get(masGrande).getPriority())) {
            masGrande = r;
        }
        if(masGrande != index) {
            NodeHeap<V> temp1= A.get(index);
            NodeHeap<V> temp2= A.get(masGrande);
            A.set(index,temp2);
            A.set(masGrande,temp1);
            maxHeapify(masGrande);
        }
    }
}
