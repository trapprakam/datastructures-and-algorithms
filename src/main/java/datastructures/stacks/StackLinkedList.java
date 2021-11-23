package main.java.datastructures.stacks;

import main.java.datastructures.lists.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class StackLinkedList {

    private LinkedList<Employee> stack;

    public StackLinkedList(){
        this.stack = new LinkedList<>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        StackLinkedList stackLinkedList = new StackLinkedList();
        Employee james = new Employee("James", "Sullivan", 123);
        Employee boo = new Employee("Boo", "", 0);
        Employee mike = new Employee("Mike", "Wazowski", 456);

        stackLinkedList.push(boo);
        stackLinkedList.push(james);
        stackLinkedList.push(mike);

        stackLinkedList.printStack();

        System.out.println("Stack Peek equal: " + stackLinkedList.peek());
        System.out.println("Popped: " + stackLinkedList.pop());

        stackLinkedList.printStack();
    }
}
