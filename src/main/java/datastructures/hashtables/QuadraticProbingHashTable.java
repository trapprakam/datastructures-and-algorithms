package main.java.datastructures.hashtables;

import main.java.datastructures.lists.Employee;

// Very Simple, collision (quadratic probing) avoidance Hash Table
// This implementation do not handle duplicate keys and resizing (load factor)
public class QuadraticProbingHashTable {

    private StoredEmployee[] hashtable;

    public QuadraticProbingHashTable() {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        // Add a step to verify the same instance
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            // Quadratic Probing: Open Addressing
            int stopIndex = hashedKey;
            int i = 1;
            // Set the first probe
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            // Continue probing until you find an empty space
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + (int) Math.pow(++i, 2) ) % hashtable.length;
            }
        }
        // If no empty space, return log/error. Or... expand the array
        if (occupied(hashedKey)) {
            System.out.println("Sorry, currently not handling collision. Your request can not be added" +
                    " to the hash table");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        Employee employee = hashtable[hashedKey].employee;
        // Rehashing
        hashtable[hashedKey] = null;
        StoredEmployee[] oldTable = hashtable;
        hashtable = new StoredEmployee[oldTable.length];
        for (StoredEmployee storedEmployee : oldTable) {
            if (storedEmployee != null) {
                put(storedEmployee.key, storedEmployee.employee);
            }
        }
        return employee;
    }

    private int hashKey(String key) {
        //return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }
        // Quadratic Probing: Open Addressing
        int stopIndex = hashedKey;
        int i = 1;
        // Set the first probe
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        // Continue probing until you find the correct key
        while (hashedKey != stopIndex && hashtable[hashedKey] != null) {
            if (hashtable[hashedKey].key.equals(key)) {
                return hashedKey;
            } else {
                hashedKey = (hashedKey + (int) Math.pow(++i, 2)) % hashtable.length;
            }
        }
        return -1;
    }

    public void printHashTable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println("Position " + i + ": " + hashtable[i].employee);
            }
        }
        System.out.println("\n");
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

    public static void main(String[] args) {
        QuadraticProbingHashTable quadraticProbingHashTable = new QuadraticProbingHashTable();

        Employee randall = new Employee("Randall", "Boggs", 789);
        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee tom = new Employee("Tom", "", 321);
        Employee jerry = new Employee("Jerry", "", 654);
        Employee scooby = new Employee("Scooby", "Doo", 456);

        quadraticProbingHashTable.put("Randall", randall);
        quadraticProbingHashTable.put("Boo", boo);
        quadraticProbingHashTable.put("Tom", tom);
        quadraticProbingHashTable.put("James", james);
        quadraticProbingHashTable.put("Mike", mike);
        quadraticProbingHashTable.put("Jerry", jerry);
        quadraticProbingHashTable.put("Scooby", scooby);

        quadraticProbingHashTable.printHashTable();

        System.out.println("Retrieve Boo: " + quadraticProbingHashTable.get("Boo"));
        System.out.println("Retrieve Tom: " + quadraticProbingHashTable.get("Tom"));

        System.out.println("Removing Randall from HashTable: " + quadraticProbingHashTable.remove("Randall"));
        quadraticProbingHashTable.printHashTable();
    }
}
