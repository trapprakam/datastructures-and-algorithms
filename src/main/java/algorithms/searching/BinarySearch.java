package main.java.algorithms.searching;

public class BinarySearch {

    public static int iterativeBinarySearch(int[] input, int valueToSearchFor) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (input[midpoint] == valueToSearchFor) {
                // Found the value, return the index
                return midpoint;
            } else if (input[midpoint] > valueToSearchFor) {
                // Search left half of the array
                end = midpoint;
            } else {
                // Search right half of the array
                start = midpoint + 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int valueToSearchFor) {
        return binarySearch(input, valueToSearchFor, 0, input.length);
    }

    public static int binarySearch(int[] input, int valueToSearchFor, int start, int end) {
        if (start >= end) {
            // Breaking condition
            return -1;
        }
        int midpoint = (start + end) / 2;
        if (input[midpoint] == valueToSearchFor) {
            // Found the value, return the index
            return midpoint;
        } else if (input[midpoint] > valueToSearchFor) {
            // Search left half of the array
            return binarySearch(input, valueToSearchFor, start, midpoint);
        } else {
            // Search right half of the array
            return binarySearch(input, valueToSearchFor, midpoint + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};
        System.out.print("Current array to search: [");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
        System.out.println("What is the index of value 1 in the array using Linear Search? " +
                iterativeBinarySearch(array, 1));
        System.out.println("What is the index of value 55 in the array using Linear Search? " +
                iterativeBinarySearch(array, 55));
        System.out.println("What is the index of value 1 in the array using Linear Search? " +
                recursiveBinarySearch(array, 1));
        System.out.println("What is the index of value 55 in the array using Linear Search? " +
                recursiveBinarySearch(array, 55));
    }
}
