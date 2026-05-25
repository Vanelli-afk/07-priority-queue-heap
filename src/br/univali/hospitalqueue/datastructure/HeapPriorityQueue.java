package br.univali.hospitalqueue.datastructure;

/**
 * A standard generic Max-Heap structure representing a Priority Queue.
 * Array tracking ensures log(n) operational limits during data mutations.
 * * @param <T> bounded parameter extending Comparable
 * @author Miguel Vanelli
 * @version 1.0
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> {

    /** Internal dynamic storage tracking nodes matching structural layout rules. */
    protected T[] elements;
    
    /** Current size metric identifying active indexes mapped. */
    protected int size;

    /**
     * Initializes the dynamic structure allocation constraints.
     *
     * @param capacity static storage sizing boundary limits
     */
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(int capacity) {
        elements = (T[]) new Comparable[capacity];
        size = 0;
    }

    /**
     * Evaluates empty storage state.
     *
     * @return true if size matches absolute empty bounds
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Evaluates filled index limit.
     *
     * @return true if max tracked nodes match absolute array capacity
     */
    public boolean isFull() {
        return size == elements.length;
    }

    /**
     * Gets total collection element size records.
     *
     * @return active node counts
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element into the storage array and performs structural heapUp shifts.
     *
     * @param element generic node value type scheduled for placement
     * @throws RuntimeException if internal collection metrics match max boundaries
     */
    public void enqueue(T element) {
        if (isFull()) {
            throw new RuntimeException("Heap full");
        }
        
        elements[size] = element;
        heapUp(size);
        size++;
    }

    /**
     * Evicts the dominant root target element out of the priority queue array maps.
     * Replaces root structural anchors and manages downward heapDown sorting loops.
     *
     * @return root array node value type matching highest sorting criteria weights
     * @throws RuntimeException if array storage maps have zero elements tracked
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Heap empty");
        }
        
        T root = elements[0];
        elements[0] = elements[size - 1];
        size--;
        heapDown(0);
        
        return root;
    }

    /**
     * Shifts nodes upward to clear sorting violations between parents and child structures.
     *
     * @param index internal position index to execute shifts from
     */
    private void heapUp(int index) {
        int parent = (index - 1) / 2;
        
        while (index > 0 &&
                elements[index].compareTo(elements[parent]) > 0) {
            swap(index, parent);
            
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    /**
     * Shifts nodes downward to resolve structural validation anomalies inside the binary layout tree.
     *
     * @param index root start location context address
     */
    private void heapDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size &&
                    elements[left].compareTo(elements[largest]) > 0) {
                largest = left;
            }
            
            if (right < size &&
                    elements[right].compareTo(elements[largest]) > 0) {
                largest = right;
            }
            
            if (largest == index)
                break;
            
            swap(index, largest);
            index = largest;
        }
    }

    /**
     * Swaps the values of two elements in the internal array storage map.
     *
     * @param i primary positioning key index
     * @param j secondary targeting index
     */
    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     * Retrieves an element directly by its index location.
     * Used exclusively for iteration routines.
     *
     * @param index targeting coordinate location
     * @return object stored at the specified location
     */
    public T get(int index) {
        return elements[index];
    }

    /**
     * Generates a raw visual matrix of internal storage arrangements.
     *
     * @return a text table identifying index structural details
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "[EMPTY HEAP]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("\n=========== HEAP ===========\n");
        
        for (int i = 0; i < size; i++) {
            sb.append("Position ")
            .append(i)
            .append(": ")
            .append(elements[i])
            .append("\n");
        }
        
        sb.append("============================");
        return sb.toString();
    }
}