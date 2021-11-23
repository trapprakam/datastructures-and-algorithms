package main.java.datastructures.hashtables.challenges;

import main.java.datastructures.lists.Employee;

import java.util.*;

// Challenge: Given a LinkedList with duplicate employee entries,
// find a way to ensure there are no duplicates in the list
// Requirements:
// 1. Remove duplicate items from a linked list
// 2. Solution must use the JDK's LinkedList class
// 3. Solution must use a HashMap
public class NoDuplicatesChallenge {

    public static int hash(int value) {
        return Math.abs(value) % 10;
    }

    public static void main(String[] args) {
        System.out.println("---------- One Solution ----------------");
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
        employees.forEach(e -> System.out.println(e));

        Map<Integer, Employee> hashMap = new HashMap<>();
        for (Employee employee : employees) {
            hashMap.putIfAbsent(employee.getId(), employee);
        }
        employees.clear();
        employees.addAll(hashMap.values());
        System.out.println("----------------------------------------");
        employees.forEach(e -> System.out.println(e));
        System.out.println("\n");

        System.out.println("---------- Another Solution ----------------");
        // Another solution
        LinkedList<Employee> employees2 = new LinkedList<>();
        employees2.add(new Employee("Jane", "Jones", 123));
        employees2.add(new Employee("John", "Doe", 5678));
        employees2.add(new Employee("Mike", "Wilson", 45));
        employees2.add(new Employee("Mary", "Smith", 5555));
        employees2.add(new Employee("John", "Doe", 5678));
        employees2.add(new Employee("Bill", "End", 3948));
        employees2.add(new Employee("Jane", "Jones", 123));
        employees2.forEach(e -> System.out.println(e));
        Map<Integer, Employee> employeeHashMap = new HashMap<>();
        ListIterator<Employee> listIterator = employees2.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (listIterator.hasNext()) {
            Employee employee = listIterator.next();
            if (employeeHashMap.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeHashMap.put(employee.getId(), employee);
            }
        }
        for (Employee employee: remove) {
            employees2.remove(employee);
        }
        System.out.println("----------------------------------------");
        employees2.forEach(e -> System.out.println(e));
    }
}
