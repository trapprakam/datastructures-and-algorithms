package main.java.algorithms.sorting;

public class SelectionSort {

    public static void swap(int[] array, int i, int j){
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // O(N^2) worst case time complexity
    public static void main(String[] args){
        int[] intArray = {23, 37, -12, 9, 55, 9, -57};
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            int largestValueIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++){
                if (intArray[i] > intArray[largestValueIndex]) {
                    largestValueIndex = i;
                }
            }
            swap(intArray, largestValueIndex , lastUnsortedIndex);
        }
        for (int j : intArray) {
            System.out.println(j);
        }
    }
}
