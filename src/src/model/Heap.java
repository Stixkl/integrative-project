package model;

import exceptions.ListIsNullException;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class Heap<V> implements IPriorityHeap<V>{

    private ArrayList<NodeHeap<V>> A;

 // The `public Heap()` constructor is initializing the `A` variable as a new `ArrayList`. This
 // constructor is called when a new `Heap` object is created.
    public Heap() {
        A = new ArrayList<>();
    }

/**
 * The function inserts a new node with a given value and value2 into a max heap data structure.
 * 
 * @param value The value parameter represents the key or priority of the element being inserted into
 * the heap. It is typically an integer value that determines the order of the elements in the heap.
 * @param value2 The parameter `value2` is of type `V` and represents the value associated with the key
 * `value` in the data structure.
 * @return The method is returning a boolean value. If the condition `value2 == null` is true, then it
 * returns false. Otherwise, it adds a new NodeHeap object to the list A, performs a buildMaxHeapify
 * operation, and returns true.
 */
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

/**
 * The function returns the NodeHeap object at the specified index.
 * 
 * @param index The index parameter is an integer value that represents the position of the NodeHeap
 * object in the arrayList A.
 * @return The method is returning a NodeHeap object at the specified index.
 */
    public NodeHeap<V> get(int index){
        return A.get(index);
    }

/**
 * The function checks if the arrayList called A is empty and returns a boolean value.
 * 
 * @return The method is returning a boolean value.
 */
    public boolean isEmpty() {
        return A.size() == 0;
    }

/**
 * The function returns the size of the arrayList A.
 * 
 * @return The size of the list A is being returned.
 */
    public int size(){
        return A.size();
    }

/**
 * The function removes a node from a list and then rebuilds the list as a max heap.
 * 
 * @param node The "node" parameter represents the node that you want to remove from the list.
 * @return The method `remove` returns a boolean value. It returns `true` if the specified node is
 * found and successfully removed from the list `A`, and `false` otherwise.
 */
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

    /**
     * The function extracts the maximum element from a heap and returns it.
     * 
     * @return The method is returning the maximum value extracted from the heap.
     */
    @Override
    public V extractMax()  throws ListIsNullException {
        if(A.isEmpty()) {
            System.out.println("The list is empty");
        }
        NodeHeap<V> max = A.get(0);
        A.set(0, A.get(A.size()-1));
        A.remove(A.size()-1);
        maxHeapify(0);
        return max.getNode();
    }

    @Override
// The `max()` method in the `Heap` class is returning the maximum value in the heap.
    public V max() {
        return A.get(0).getNode();
    }

/**
 * The function performs a heap sort on a list of elements.
 */
    public void heapSort(){
        buildMaxHeapify();
        for(int i= A.size()-1; i >=1;i--){
            NodeHeap<V> temp = A.get(0);
            maxHeapify(0);
            A.set(i,temp);
        }
    }

   /**
    * The function increases the priority of a node in a heap and adjusts the heap structure
    * accordingly.
    * 
    * @param value The value parameter represents the value of the node whose priority needs to be
    * increased.
    * @param newValue The new value that you want to assign to the priority of the node.
    */
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

/**
 * The function "show" returns a string representation of the nodes in the list A.
 * 
 * @return The method is returning a string representation of the nodes in the list A, with each node
 * on a new line.
 */
    public String show() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < A.size(); i++) {
            msg.append(A.get(i).getNode().toString()).append("\n");
        }
        return msg.toString();
    }

/**
 * The function searches for a specific node in a list and returns it if found, otherwise it returns
 * null.
 * 
 * @param node The parameter "node" is the value that you want to search for in the list "A".
 * @return The method is returning the node that matches the input node, or null if no matching node is
 * found.
 */
    public V search(V node){
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i).getNode().equals(node)){
                return A.get(i).getNode();
            }
        }
        return null;
    }

/**
 * The function returns the index of the parent node in a binary tree.
 * 
 * @param index The index parameter represents the index of a node in a binary heap data structure.
 * @return The method is returning the index divided by 2.
 */
    private int parent(int index) {
        return index/2;
    }

/**
 * The function "buildMaxHeapify" builds a max heap by calling the "maxHeapify" function on each
 * element in reverse order.
 */
    public void buildMaxHeapify() {
        for(int i= A.size()-1; i >= 0;i--){
            maxHeapify(i);
        }
    }

    /**
     * The maxHeapify function is used to maintain the max heap property in a binary heap data
     * structure.
     * 
     * @param index The index parameter represents the index of the element in the heap that needs to
     * be heapified.
     */
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
