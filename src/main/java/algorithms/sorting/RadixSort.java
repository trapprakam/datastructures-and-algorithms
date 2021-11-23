package main.java.algorithms.sorting;

public class RadixSort {

    public static void radixSort(int[] input, int radix, int width){
        // Sort by the width
        for (int i = 0; i < width; i++){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix){
        // Create a counting array
        int[] countArray = new int[radix];

        // Implement count in respect to current position
        for(int value: input){
            countArray[getDigit(position, value, radix)]++;
        }

        // Adjust count array for stable sorting
        for(int i = 1; i < countArray.length; i++){
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        // Sort
        int numItems = input.length;
        int[] tempArray = new int[numItems];
        for(int index = numItems - 1; index >= 0; index--){
            tempArray[--countArray[getDigit(position, input[index], radix)]] = input[index];
        }

        //Copy temp array to original array
        // Note: This can be replaced with System.arraycopy()
        for(int j = 0; j < numItems; j++){
            input[j] = tempArray[j];
        }

    }

    public static int getDigit(int position, int value, int radix){
        return value / (int) Math.pow(radix, position) % radix;
    }

    public static void main(String[] args){
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};
        radixSort(array, 10, 4);
        for (int j : array) {
            System.out.println(j);
        }
    }
}
