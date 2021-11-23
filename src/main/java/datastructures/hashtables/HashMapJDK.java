package main.java.datastructures.hashtables;

import main.java.datastructures.lists.Employee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapJDK {

    private Map<String, Employee> hashMap;

    public HashMapJDK(){
        this.hashMap = new HashMap<>();
    }

    public HashMapJDK(int initialCapacity, float loadFactor) {
        this.hashMap = new HashMap<>(initialCapacity, loadFactor);
    }

    public void put (String key, Employee employee) {
        // This method will overwrite values if key already exist
        hashMap.put(key, employee);
    }

    public void putIfAbsent(String key, Employee employee) {
        // This method will only put the entry as requested if and only if the key
        // is not already in use.
        hashMap.putIfAbsent(key, employee);
    }

    public void printHashMap() {
        Iterator<Employee> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        HashMapJDK hashMapJDK = new HashMapJDK();
        Employee tom = new Employee("Tom", "", 321);
        Employee jerry = new Employee("Jerry", "", 654);
        Employee scooby = new Employee("Scooby", "Doo", 456);
        Employee boo = new Employee("Boo", "", 0);
        Employee james = new Employee("James", "Sullivan", 123);
        Employee mike = new Employee("Mike", "Wazowski", 456);

        hashMapJDK.put("Boo", boo);
        hashMapJDK.put("Tom", tom);
        hashMapJDK.put("James", james);
        hashMapJDK.put("Mike", mike);
        hashMapJDK.put("Jerry", jerry);
        hashMapJDK.put("Scooby", scooby);

        hashMapJDK.printHashMap();
    }
}
