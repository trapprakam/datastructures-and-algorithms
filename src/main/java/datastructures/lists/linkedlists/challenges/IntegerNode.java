package main.java.datastructures.lists.linkedlists.challenges;

import main.java.datastructures.lists.Employee;
import main.java.datastructures.lists.linkedlists.EmployeeNode;

public class IntegerNode {

    private int number;
    private IntegerNode next;

    public IntegerNode(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public IntegerNode getNext() {
        return next;
    }

    public void setNext(IntegerNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "IntegerNode{" +
                "number=" + number +
                '}';
    }
}
