package main.java.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] input, int startIndex, int endIndex){
        // This is using the first element in the given array/subarray (based off the startIndex)
        // as the pivot
        int pivot = input[startIndex];
        int i = startIndex;
        int j = endIndex;

        while(i < j){
            // Note: Empty loop body
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }
            // Note: Empty loop body
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }

    public static void quickSort(int[] input, int startIndex, int endIndex){
        if (endIndex - startIndex < 2){
            return;
        }
        // Pivot and sort the whole array, then pivot and sort the left sub arrays, then
        // pivot and sort the right sub arrays.
        int pivotIndex = partition(input, startIndex, endIndex);
        quickSort(input, startIndex, pivotIndex);
        quickSort(input, pivotIndex + 1, endIndex);
    }

    public static void main(String[] args){
        int[] array = {20, 35, -15, 7, 55, 1, -22};
        quickSort(array, 0, array.length);
        for (int j : array) {
            System.out.println(j);
        }

        int[] arrayRepeat = {20, 35, -15, 7, 55, 1, -22};
        // Uses a Dual-Pivot QuickSort using the JDK Arrays library
        // O(n log n)
        Arrays.sort(arrayRepeat);
        for (int j : array) {
            System.out.println(j);
        }
    }
}
