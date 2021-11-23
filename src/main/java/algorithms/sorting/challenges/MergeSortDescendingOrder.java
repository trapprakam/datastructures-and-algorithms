package main.java.algorithms.sorting.challenges;

public class MergeSortDescendingOrder {

    public static void mergeSortDescending(int[] input, int startIndex, int endIndex){
        // Below, the two recursion calls will split the array to single element arrays
        // starting with left side [0, mid]. After the sortMerge function is called to
        // sort and merge the left side, recursively the right side [mid, array.length]
        // will be split, sorted, and merged as well. After those steps are done. The left
        // and right sorted partitions will be sorted and merged
        if (endIndex - startIndex < 2){
            return;
        }
        int midpoint = (startIndex + endIndex) / 2;
        mergeSortDescending(input, startIndex, midpoint);
        mergeSortDescending(input, midpoint, endIndex);
        sortMergeDescending(input, startIndex, midpoint, endIndex);
    }

    public static void sortMergeDescending(int[] input, int startIndex, int midpoint, int endIndex){
        if (input[midpoint - 1] >= input[midpoint]){
            return;
        }
        int i = startIndex;
        int j = midpoint;
        int tempIndex = 0;
        int[] tempArray = new int[endIndex - startIndex];
        while (i < midpoint && j < endIndex){
            tempArray[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, startIndex + tempIndex, midpoint - i);
        System.arraycopy(tempArray, 0, input, startIndex, tempIndex);
    }

    public static void main(String[] args){
        // Sort challenge 1: Implement merge sort for sorting an array in descending order
        int[] arrayForChallenge = {20, 35, -15, 7, 55, 1, -22};
        mergeSortDescending(arrayForChallenge, 0, arrayForChallenge.length);
        for (int k : arrayForChallenge) {
            System.out.println(k);
        }
    }
}
