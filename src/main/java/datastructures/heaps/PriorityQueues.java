package main.java.datastructures.heaps;

import java.util.PriorityQueue;

public class PriorityQueues {

    public static void main(String[] args) {
        // MinHeap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1343);
        priorityQueue.add(54);
        priorityQueue.add(0);
        priorityQueue.add(-3492);
        priorityQueue.add(429);

        for (Object num: priorityQueue.toArray()) {
            System.out.print(num + ", ");
        }
        System.out.println("\n");
        System.out.println("Priority Queue peek: " + priorityQueue.peek());
        System.out.println("Remove element with the highest priority (root): " + priorityQueue.remove());
        System.out.println("Priority Queue peek: " + priorityQueue.peek());
    }
}
