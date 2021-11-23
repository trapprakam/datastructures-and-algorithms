package main.java.algorithms.sorting;

public class ShellSort {

    // O(N^2) worst case time complexity
    public static void main(String[] args){
        int[] intArray = {34, -5, 78, 7, -76, 12, 58};
        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int elementToBeInserted = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > elementToBeInserted){
                    // Shift
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                // Insert
                intArray[j] = elementToBeInserted;
            }
        }
        for (int j : intArray) {
            System.out.println(j);
        }
    }
}
