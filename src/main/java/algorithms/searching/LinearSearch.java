package main.java.algorithms.searching;

public class LinearSearch {

    public static int linearSearch(int[] input, int valueToSearchFor) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == valueToSearchFor) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {20, 55, -15, 35, 7, 1, -22};
        System.out.println("What is the index of value 7 in the array using Linear Search? " +
                linearSearch(array, 7));
        System.out.println("What is the index of value -22 in the array using Linear Search? " +
                linearSearch(array, -22));
        System.out.println("What is the index of value 20 in the array using Linear Search? " +
                linearSearch(array, 20));
        System.out.println("What is the index of value 100 in the array using Linear Search? " +
                linearSearch(array, 100));
    }
}
