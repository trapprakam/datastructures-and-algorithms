package main.java.datastructures.hashtables;

import main.java.datastructures.lists.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

// Very Simple, collision (Chaining) avoidance Hash Table
// This implementation do not handle duplicate keys and resizing (load factor)
public class ChainedHashTable {

    private LinkedList<StoredEmployee>[] hashTable;

    public ChainedHashTable() {
        this.hashTable = new LinkedList[10];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }

    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee storedEmployee;
        while (iterator.hasNext()) {
            storedEmployee = iterator.next();
            if (storedEmployee.key.equals(key)) {
                return storedEmployee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();
        StoredEmployee storedEmployee = null;
        int storedEmployeeIndex = -1;
        while (iterator.hasNext()) {
            storedEmployee = iterator.next();
            storedEmployeeIndex ++;
            if (storedEmployee.key.equals(key)) {
                break;
            }
        }
        if (storedEmployee == null || !storedEmployee.key.equals(key)) {
            return null;
        } else {
            hashTable[hashedKey].remove(storedEmployeeIndex);
            return storedEmployee.employee;
        }
    }

    private int hashKey(String key) {
        //return  key.length() % hashTable.length;
        return Math.abs(key.hashCode() % hashTable.length);
    }

    // StoredEmployee class implementation to assist with collision
    public static class StoredEmployee{

        public String key;
        public Employee employee;

        public StoredEmployee(String key, Employee employee){
            this.key = key;
            this.employee = employee;
        }
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i].isEmpty()) {
                System.out.println("Position " + i + ": empty");
            } else {
                System.out.print("Position " + i + ": ");
                ListIterator<StoredEmployee> iterator = hashTable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print(" <==> ");
                }
                System.out.println("null");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ChainedHashTable chainedHashTable = new ChainedHashTable();

        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee tom = new Employee("Tom", "", 321);
        Employee jerry = new Employee("Jerry", "", 654);
        Employee scooby = new Employee("Scooby", "Doo", 456);
        Employee randall = new Employee("Randall", "Boggs", 789);

        chainedHashTable.put("Randall", randall);
        chainedHashTable.put("Boo", boo);
        chainedHashTable.put("James", james);
        chainedHashTable.put("Mike", mike);
        chainedHashTable.put("Tom", tom);
        chainedHashTable.put("Jerry", jerry);
        chainedHashTable.put("Scooby", scooby);

        chainedHashTable.printHashTable();

        System.out.println("Retrieve Boo: " + chainedHashTable.get("Boo"));
        System.out.println("Retrieve Tom: " + chainedHashTable.get("Tom"));
        System.out.println("\n");

        System.out.println("Removing Randall from HashTable: " + chainedHashTable.remove("Randall"));
        System.out.println("\n");
        chainedHashTable.printHashTable();

        System.out.println("Removing Jerry from HashTable: " + chainedHashTable.remove("Jerry"));
        System.out.println("\n");
        chainedHashTable.printHashTable();
    }
}
