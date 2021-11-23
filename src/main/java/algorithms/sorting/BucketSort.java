package main.java.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void sort(int[] input) {
        List<Integer>[] buckets = new List[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Hash (Scattering Phase)
        for (int element : input) {
            buckets[hash(element)].add(element);
        }
        // Sort: Currently using collections.sort, which provides an adaptive merge sort
        // but an insertion sort will perform better if there's a good hashing function.
        // O(n log n) - worst case
        for (List<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }
        // Merge (Gathering Phase)
        int j = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                input[j++] = value;
            }
        }

    }

    private static int hash(int value) {
        return value / 10;
    }

    public static void main(String[] args) {
        int[] array = {54, 46, 83, 66, 95, 92, 43};
        sort(array);
        System.out.print("Sorted array using Bucket Sort: [");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "]");
            }
        }
    }
}
