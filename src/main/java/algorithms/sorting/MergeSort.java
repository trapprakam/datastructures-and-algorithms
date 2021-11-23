package main.java.algorithms.sorting;

public class MergeSort {

    public static void mergeSort(int[] input, int startIndex, int endIndex){
        // Below, the two recursion calls will split the array to single element arrays
        // starting with left side [0, mid]. After the sortMerge function is called to
        // sort and merge the left side, recursively the right side [mid, array.length]
        // will be split, sorted, and merged as well. After those steps are done. The left
        // and right sorted partitions will be sorted and merged
        if (endIndex - startIndex < 2){
            return;
        }
        int midpoint = (startIndex + endIndex) / 2;
        mergeSort(input, startIndex, midpoint);
        mergeSort(input, midpoint, endIndex);
        sortMerge(input, startIndex, midpoint, endIndex);
    }

    public static void sortMerge(int[] input, int startIndex, int midpoint, int endIndex){
        if (input[midpoint - 1] <= input[midpoint]){
            return;
        }
        int i = startIndex;
        int j = midpoint;
        int tempIndex = 0;
        int[] tempArray = new int[endIndex - startIndex];
        while (i < midpoint && j < endIndex){
                tempArray[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, startIndex + tempIndex, midpoint - i);
        System.arraycopy(tempArray, 0, input, startIndex, tempIndex);
    }

    public static void main(String[] args){
        int[] array = {20, 3, -10, 5, 89, 9, -67};
        mergeSort(array, 0, array.length);
        for (int j : array) {
            System.out.println(j);
        }
    }
}
