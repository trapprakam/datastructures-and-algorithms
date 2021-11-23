package main.java.datastructures.lists.linkedlists;

import main.java.datastructures.lists.Employee;

public class SinglyLinkedLists {

    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFromFront(){
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        head = removedNode.getNext();
        removedNode.setNext(null);
        size--;
        return removedNode;
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
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        SinglyLinkedLists singlyLinkedLists = new SinglyLinkedLists();

        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        System.out.println("Is the LinkedList empty currently? " + singlyLinkedLists.isEmpty());
        singlyLinkedLists.addToFront(boo);
        singlyLinkedLists.addToFront(james);
        singlyLinkedLists.addToFront(mike);
        singlyLinkedLists.addToFront(randall);
        System.out.println("Is the LinkedList still empty? " + singlyLinkedLists.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + singlyLinkedLists.getSize());
        singlyLinkedLists.printLinkedList();

        singlyLinkedLists.removeFromFront();
        System.out.println("How many items are in the LinkedList currently? " + singlyLinkedLists.getSize());
        singlyLinkedLists.printLinkedList();
    }
}
