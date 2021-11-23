package main.java.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Arrays {

    public int[] twoSum(int[] nums, int target) {
        int[] toReturn = new int[2];
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (!storage.containsKey(difference)) {
                storage.put(nums[i], i);
            } else {
                toReturn[0] = storage.get(difference);
                toReturn[1] = i;
                return toReturn;
            }
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Arrays arrays = new Arrays();
        int[] nums = {2, 7, 11, 15};
        int[] result = arrays.twoSum(nums, 9);
        // When you create an array, you have to specify the size
        // of the array. Arrays are not a dynamic data structure.
        // This mean, once you set the size of the array. It can not
        // be changed.

        // Pros:
        //      1. Fast retrieval of an element of the array from memory if
        //         your retrieving an element by the index.
        //         Function to retrieve an element of an array from memory:
        // 							x + i * y
        //         x = start address of the first element of an array in memory
        //         i = index of an element of interest
        //         y = the size of the element
        //         Time complexity: O(1) - Constant
        //
        // Cons:
        //      1. The size of an array cannot be changed
        //      2. If the index of a requested element in an array
        //		   is not known. Then you will have to loop through
        //		   the array until you find the element resulting in
        //         the worst case scenario a time complexity of O(N)
        int a = 10 % 10;
        int b = 10 / 10;
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        // To retrieve the number 7 if index is known.
        // O(1) worst case time complexity
        int seven = intArray[3];

        // To retrieve the number 7 if index is not known
        // O(N) worst case time complexity
        for (int j : intArray) {
            if (j == 7) {
                break;
            }
        }

        // To add an element to an array
        // O(N) worst case time complexity - if array is full

        // A new array will need to be created
        int[] newArray = new int[8];
        // The data will need to be copied over to the new array
        for(int i = 0; i < intArray.length; i++) {
            newArray[i] = intArray[i];
        }
        // Add the new element
        newArray[7] = 100;
        // Set the variable intArray to point to the newArray
        // This will allow the previous intArray to be garbage collected
        intArray = newArray;

        // Insert or update an element if index is known
        // O(1) worst case time complexity
        intArray[2] = 125;

        // Insert or update an element if index is not known
        // O(N) worst case time complexity
        intArray[2] = -15;
        for(int i = 0; i < intArray.length; i++) {
            if (intArray[i] == -15){
                intArray[i] = 125;
                break;
            }
        }

        // Delete an element in the array if index is known, and you treat a null element as -1
        // You can't use null because int is a primitive type
        // O(1)
        intArray[2] = -1;

        // Delete an element in the array if index is not known
        // O(N)
        intArray[2] = -15;
        int counter = 0;
        int[] newArrayAfterDeletion = new int[7];
        for(int i = 0; i < intArray.length; i++) {
            if (intArray[i] != -15){
                if (newArrayAfterDeletion.length != counter){
                    newArrayAfterDeletion[counter] = intArray[i];
                    counter += 1;
                } else {
                    break;
                }
            }
        }
        intArray = newArrayAfterDeletion;
    }
}

