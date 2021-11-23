package main.java.algorithms.sorting;

public class InsertionSort {

    // O(N^2) worst case time complexity
    public static void main(String[] args){
        int[] intArray = {67, 2, 90, 47, 76, 9, 7};
        int i;
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++){
            int elementToBeInserted = intArray[firstUnsortedIndex];
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > elementToBeInserted; i--) {
                    // Shift
                    intArray[i] = intArray[i - 1];
            }
            // Insert
            intArray[i] = elementToBeInserted;
        }
        for (int j : intArray) {
            System.out.println(j);
        }
    }
}
