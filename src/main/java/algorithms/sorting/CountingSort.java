package main.java.algorithms.sorting;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CountingSort {

    public static void countingSort(int[] input, int min, int max){
       int[] countingArray = new int[(max - min) + 1];
        for (int i : input) {
            countingArray[i - min]++;
        }
        int j = 0;  // Keep track of place in counting array
        for (int i = min; i <= max; i++){
            while (countingArray[i - min] > 0){
                input[j++] = i;
                countingArray[i - min]--;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};//{20, 15, 18, 12, 20, 18, 17, 10, 14, 13};
        //countingSort(array, 10, 20);
        countingSort(array, 2, 10);
        for (int j : array) {
            System.out.println(j);
        }
    }
}
