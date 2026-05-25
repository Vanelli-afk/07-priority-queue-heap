package br.univali.hospitalqueue.datastructure;

public class HeapPriorityQueue<T extends Comparable<? super T>> {

    protected T[] elements;
    protected int size;

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(int capacity) {
        elements = (T[]) new Comparable[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public int size() {
        return size;
    }

    public void enqueue(T element) {

        if (isFull()) {
            throw new RuntimeException("Heap full");
        }
        
        elements[size] = element;
        heapUp(size);
        size++;
    }

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

    private void heapUp(int index) {
        int parent = (index - 1) / 2;
        
        while (index > 0 &&
                elements[index].compareTo(elements[parent]) > 0) {
            swap(index, parent);
            
            index = parent;
            parent = (index - 1) / 2;
        }
    }

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

    private void swap(int i, int j) {
        T temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

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