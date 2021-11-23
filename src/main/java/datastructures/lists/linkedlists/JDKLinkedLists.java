package main.java.datastructures.lists.linkedlists;

import main.java.datastructures.lists.Employee;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JDKLinkedLists {

    public static void printLinkedList(List<Employee> linkedList) {
        Iterator iterator = linkedList.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.print("(<- TAIL) ");
        System.out.println("null");
    }

    public static void main(String[] args) {

        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        // Uses a doubly-linked list implementation
        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(boo);
        linkedList.addFirst(james);
        linkedList.addLast(mike);
        linkedList.addLast(randall);

        System.out.println("Is the LinkedList empty? " + linkedList.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + linkedList.size());
        printLinkedList(linkedList);

        linkedList.removeFirst();
        System.out.println("Is the LinkedList empty? " + linkedList.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + linkedList.size());
        printLinkedList(linkedList);

        linkedList.removeLast();
        System.out.println("Is the LinkedList empty? " + linkedList.isEmpty());
        System.out.println("How many items are in the LinkedList currently? " + linkedList.size());
        printLinkedList(linkedList);
    }
}
