package main.java.datastructures.queues;

import main.java.datastructures.lists.Employee;
import java.util.NoSuchElementException;

public class QueueArray {

    private Employee[] queue;
    private int front;
    private int back;

    public QueueArray(int capacity) {
        this.queue = new Employee[capacity];
    }

    // This is inefficient memory usage and will result in unused memory space
    // public void add(Employee employee) {
    //     if (back == queue.length) {
    //         // need to resize the backing array
    //         // O(n)
    //         Employee[] newArray = new Employee[2 * queue.length];
    //         System.arraycopy(queue, 0, newArray, 0, queue.length);
    //         queue = newArray;
    //     }
    //     //O(1)
    //     queue[back++] = employee;
    // }
    //
    // public Employee remove(){
    //     if (isEmpty()) {
    //         throw new NoSuchElementException();
    //     }
    //     Employee employee = queue[front];
    //     queue[front++] = null;
    //     if (size() == 0) {
    //         front = 0;
    //         back = 0;
    //     } else if (front == queue.length) {
    //         front = 0;
    //     }
    //     return employee;
    // }

    // Circular Queue Implementation
    public void add(Employee employee) {
        if (size() == queue.length - 1) {
            // need to resize the backing array
            // O(n)
            int preWrapSize = size();
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, front, newArray, 0, queue.length - front);
            System.arraycopy(queue, 0, newArray, queue.length - front, back);
            queue = newArray;
            // Update front and back parameters
            front = 0;
            back = preWrapSize;
        }
        //O(1)
        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front++] = null;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size(){
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(5);
        Employee randall = new Employee("Randall", "Boggs", 789);
        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);

        queueArray.add(mike);
        queueArray.add(randall);
        queueArray.add(boo);
        queueArray.add(james);

        queueArray.printQueue();

        System.out.println("Removed: " + queueArray.remove());
        System.out.println("Removed: " + queueArray.remove());

        System.out.println("Stack Peek equal: " + queueArray.peek());

        queueArray.printQueue();

        queueArray.add(mike);
        queueArray.add(randall);
        System.out.println("Removed: " + queueArray.remove());
        System.out.println("Removed: " + queueArray.remove());
        queueArray.add(james);
        queueArray.add(boo);
        System.out.println("Removed: " + queueArray.remove());
        queueArray.add(mike);
        queueArray.printQueue();
    }
}
