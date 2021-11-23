package main.java.datastructures.hashtables.challenges;

// Challenge: Create a Hash Function for adding elements to an array
public class HashFunctionChallenge {

    public static int hash(int value) {
        // 10 is hardcoded, because in this challenge the capacity of thr array do not change
        // The capacity of array is used in the hashing function to make sure no out array index errors occur.
        return Math.abs(value) % 10;
    }

    public static void main(String[] args) {
        int[] nums = new int[10];
        int[] numsToAdd = {59382, 43, 6894, 500, 99, -58};
        for (int element : numsToAdd) {
            nums[hash(element)] = element;
        }
        for (int value: nums) {
            System.out.println(value);
        }
    }
}
