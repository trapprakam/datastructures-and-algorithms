package main.java.datastructures.lists.linkedlists;

import main.java.datastructures.lists.Employee;

import java.util.Objects;

public class DoublyLinkedLists {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (head != null){
            node.setNext(head);
            head.setPrevious(node);
        } else {
            tail = node;
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail != null){
            tail.setNext(node);
            node.setPrevious(tail);
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    public EmployeeNode removeFromFront(){
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        if (removedNode.getNext() == null) {
            head = null;
            tail = null;
        } else {
            head = removedNode.getNext();
            head.setPrevious(removedNode.getPrevious());
            removedNode.setNext(null);  // Cleaning up
        }
        size--;
        return removedNode;
    }

    public EmployeeNode removeFromEnd(){
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = tail;
        if (removedNode.getPrevious() == null) {
            tail = null;
            head = null;
        } else {
            tail = removedNode.getPrevious();
            tail.setNext(removedNode.getNext());
            removedNode.setPrevious(null);  // Cleaning up

        }
        size--;
        return removedNode;
    }

    public void incrementSize(){
        // This is a method that should not be implemented or public (if implemented)
        // I implemented this method with a public accessor for a challenge I was doing for a course.
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printLinkedList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.print("(<- TAIL) ");
        System.out.println("null");
    }

    public EmployeeNode getHead() {
        return head;
    }

    public EmployeeNode getTail() {
        return tail;
    }



    public static void main(String[] args){
        DoublyLinkedLists doublyLinkedLists = new DoublyLinkedLists();

        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        doublyLinkedLists.addToFront(boo);
        doublyLinkedLists.addToFront(mike);
        doublyLinkedLists.addToEnd(james);
        doublyLinkedLists.addToEnd(randall);
        System.out.println("Is the LinkedList empty? " + doublyLinkedLists.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + doublyLinkedLists.getSize());
        doublyLinkedLists.printLinkedList();

        doublyLinkedLists.removeFromFront();
        System.out.println("Is the LinkedList empty? " + doublyLinkedLists.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + doublyLinkedLists.getSize());
        doublyLinkedLists.printLinkedList();

        doublyLinkedLists.removeFromEnd();
        System.out.println("Is the LinkedList empty? " + doublyLinkedLists.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + doublyLinkedLists.getSize());
        doublyLinkedLists.printLinkedList();


    }
}
