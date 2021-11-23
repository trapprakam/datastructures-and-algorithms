package main.java.algorithms.sorting.challenges;

public class InsertionSortWithRecursion {

    public static void insertionSort(int[] array, int numItems) {
        if (numItems < 2){
            return;
        }
        insertionSort(array, --numItems);
        sort(array, numItems);
    }

    public static void sort(int[] array, int firstUnsortedIndex){
        if (array[firstUnsortedIndex - 1] < array[firstUnsortedIndex]){
            // For visual, can be removed
            printVisualStatement(array, firstUnsortedIndex);
            return;
        }
        int i;
        int elementToBeInserted = array[firstUnsortedIndex];
        for (i = firstUnsortedIndex; i > 0 && array[i - 1] > elementToBeInserted; i--) {
            // Shift
            array[i] = array[i - 1];
        }
        // Insert
        array[i] = elementToBeInserted;
        // For visual, can be removed
        printVisualStatement(array, firstUnsortedIndex);
    }

    public static void printVisualStatement(int[] array, int firstUnsortedIndex) {
        System.out.println("Result of sort when the first unsorted index = " + firstUnsortedIndex);
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]);
            if (j != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\n ------------------------");
    }

    // O(n log n) worst case time complexity
    public static void main(String[] args){
        int[] arrayForChallenge = {20, 35, -15, 7, 55, 1, -22};
        insertionSort(arrayForChallenge, arrayForChallenge.length);
    }
}
