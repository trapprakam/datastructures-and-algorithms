package main.java.datastructures.lists.linkedlists.challenges;

import main.java.datastructures.lists.Employee;
import main.java.datastructures.lists.linkedlists.DoublyLinkedLists;
import main.java.datastructures.lists.linkedlists.EmployeeNode;

import java.util.Objects;

public class DLLAddBeforeMethodImplementation extends DoublyLinkedLists {

    public boolean addBefore(Employee employeeToAdd, Employee existingEmployee) {
        if (isEmpty()) {
            return false;
        }
        if (getHead().getEmployee() == existingEmployee) {
            addToFront(employeeToAdd);
        } else if (getTail().getEmployee() == existingEmployee) {
            EmployeeNode employeeNode = new EmployeeNode(employeeToAdd);
            employeeNode.setNext(getTail());
            employeeNode.setPrevious(getTail().getPrevious());
            employeeNode.getPrevious().setNext(employeeNode);
            getTail().setPrevious(employeeNode);
            incrementSize();
        } else {
            EmployeeNode current = getHead().getNext();
            // Iterate until we find the existing employee or not.
            while (current != null && !current.getEmployee().equals(existingEmployee)) {
                current = current.getNext();
            }
            if (current == null) {
                return false;
            } else {
                EmployeeNode employeeNode = new EmployeeNode(employeeToAdd);
                employeeNode.setNext(current);
                employeeNode.setPrevious(current.getPrevious());
                employeeNode.getPrevious().setNext(employeeNode);
                current.setPrevious(employeeNode);
                incrementSize();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DLLAddBeforeMethodImplementation dllAddBeforeMethodImplementation = new DLLAddBeforeMethodImplementation();

        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        dllAddBeforeMethodImplementation.addToEnd(boo);
        dllAddBeforeMethodImplementation.addToFront(james);
        dllAddBeforeMethodImplementation.addToFront(randall);
        dllAddBeforeMethodImplementation.addBefore(mike, james);
        dllAddBeforeMethodImplementation.printLinkedList();
    }
}
