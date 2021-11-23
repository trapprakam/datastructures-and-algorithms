package main.java.datastructures.hashtables;

import main.java.datastructures.lists.Employee;

// Very Simple, collision (linear probing) avoidance Hash Table
// This implementation do not handle duplicate keys and resizing (load factor)
public class LinearProbingHashTable {

    private StoredEmployee[] hashtable;

    public LinearProbingHashTable() {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            // Linear Probing: Open Addressing
            int stopIndex = hashedKey;
            // Set the first probe
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            // Continue probing until you find an empty space
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
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
        // Linear Probing: Open Addressing
        int stopIndex = hashedKey;
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
                hashedKey = (hashedKey + 1) % hashtable.length;
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
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable();

        Employee randall = new Employee("Randall", "Boggs", 789);
        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);
        Employee tom = new Employee("Tom", "", 321);
        Employee jerry = new Employee("Jerry", "", 654);
        Employee scooby = new Employee("Scooby", "Doo", 456);

        linearProbingHashTable.put("Randall", randall);
        linearProbingHashTable.put("Boo", boo);
        linearProbingHashTable.put("James", james);
        linearProbingHashTable.put("Mike", mike);
        linearProbingHashTable.put("Tom", tom);
        linearProbingHashTable.put("Jerry", jerry);
        linearProbingHashTable.put("Scooby", scooby);

        linearProbingHashTable.printHashTable();

        System.out.println("Retrieve Boo: " + linearProbingHashTable.get("Boo"));
        System.out.println("Retrieve Tom: " + linearProbingHashTable.get("Tom"));

        System.out.println("Removing Randall from HashTable: " + linearProbingHashTable.remove("Randall"));
        linearProbingHashTable.printHashTable();
    }
}
