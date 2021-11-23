package main.java.datastructures.lists;

import java.util.List;
import java.util.Vector;

public class Vectors {

    public static void main(String[] args){

        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Randall", "Boggs", 789));
        employeeList.add(new Employee("Mike", "Wazowski", 456));
        employeeList.add(new Employee("James", "Sullivan", 123));

        // Adding threads to show the benefit of Vector class

        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println("What employee is at index 1? " + employeeList.get(1));
        System.out.println("Is the list empty? " + employeeList.isEmpty());
        System.out.println("What is the size of the List (The number of elements in the list/array currently)? " +
                employeeList.size());
        employeeList.set(2, new Employee("Boo", "", 0));
        System.out.println("Is Boo now an employee at Monsters Inc.? " + employeeList.contains(new Employee("Boo", "", 0)));
    }
}
