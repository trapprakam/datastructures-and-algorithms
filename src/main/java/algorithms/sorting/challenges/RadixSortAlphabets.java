package main.java.algorithms.sorting.challenges;

public class RadixSortAlphabets {

    public static void radixSort(String[] input, int radix, int width){
        // Sort by the width
        for (int i = width - 1; i >= 0; i--){
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix){
        // Create a counting array
        int[] countArray = new int[radix];

        // Implement count in respect to current position
        for(String value: input){
            countArray[getAlphabetIndex(position, value)]++;
        }

        // Adjust count array for stable sorting
        for(int i = 1; i < countArray.length; i++){
            countArray[i] = countArray[i] + countArray[i - 1];
        }

        // Sort
        int numItems = input.length;
        String[] tempArray = new String[numItems];
        for(int index = numItems - 1; index >= 0; index--){
            tempArray[--countArray[getAlphabetIndex(position, input[index])]] = input[index];
        }

        //Copy temp array to original array
        // Note: This can be replaced with System.arraycopy()
        for(int j = 0; j < numItems; j++){
            input[j] = tempArray[j];
        }

    }

    public static int getAlphabetIndex(int position, String value){
        return value.charAt(position) - 'a';
    }

    public static void main(String[] args){
        String[] array = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};
        radixSort(array, 26, 5);
        for (String j : array) {
            System.out.println(j);
        }
    }
}
