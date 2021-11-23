package main.java.datastructures.stacks;

import main.java.datastructures.lists.Employee;

import java.util.EmptyStackException;

public class StackArray {

    private Employee[] stack;
    private int top;

    public StackArray(int capacity) {
        this.stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize the backing array
            // O(n)
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        //O(1)
        stack[top++] = employee;
    }

    public Employee pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size(){
        return top;
    }

    public void printStack() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(10);
        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        stackArray.push(boo);
        stackArray.push(james);
        stackArray.push(mike);
        stackArray.push(randall);

        stackArray.printStack();

        System.out.println("Stack Peek equal: " + stackArray.peek());
        System.out.println("Popped: " + stackArray.pop());

        stackArray.printStack();


    }
}
