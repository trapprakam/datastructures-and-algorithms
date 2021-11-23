package main.java.datastructures.heaps;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    // Note: When dealing with heaps, you're really never going to take some
    // random value off the heap. You will be taking the root. There are implementations
    // that delete other values except the root, this implementation is one.
    public int delete(int index) {
        // You can implement it to accept a value as input, but a search algorithm
        // will need to be used first to find the index of the element in the array
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        // Replace with the right most element in the lower level of the binary heap
        heap[index] = heap[size - 1];

        if (index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }

    public void sort() {
        int lastHeapIndex = size - 1;
        for (int i = 0; i < lastHeapIndex; i++) {
            int temp = heap[0];
            heap[0] = heap[lastHeapIndex - i];
            heap[lastHeapIndex - i] = temp;
            // Heapify
            fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    //Heapify
    public void fixHeapAbove(int index) {
        int newValue = heap[index];
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);
            int rightChild = getChild(index, false);
            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                // If child is greater than parent, swap
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    // Heap is fixed
                    break;
                }
                index = childToSwap;
            } else {
                // Heap is fixed
                break;
            }
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is Empty");
        } else {
            return heap[0];
        }
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void printHeap() {
        for (int i = 0;  i <  size; i++) {
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println("\n");
    }
}
