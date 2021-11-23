package main.java.datastructures.heaps;

public class MaxHeap {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
        //System.out.println("What is at the root? " + heap.peek());
        //heap.delete(0);
        //heap.printHeap();
        //System.out.println("What is at the root? " + heap.peek());

        System.out.print("Sort the heap in ascending order (HeapSort): ");
        heap.sort();
        heap.printHeap();
    }
}
