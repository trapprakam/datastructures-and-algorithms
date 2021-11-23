package main.java.algorithms;


public class Recursion {

    // 1! = 1 * 1 = 0!
    // 2! = 2 * 1 = 2 * 1!
    // 3! = 3 * 2 * 1 = 3 * 2!
    // 4! = 4 * 3 * 2 * 1 = 4 * 3!
    // n! = n * (n - 1)!
    public static int recursiveFactorial(int number){
        // Base case (Breaking condition)
        if (number == 0){
            return 1;
        }
        // Note: This will create some overhead
        return number * recursiveFactorial(number - 1);
    }

    public static void main(String[] args){
        System.out.println("3! = " + recursiveFactorial(3));
        System.out.println("6! = " + recursiveFactorial(6));
    }
}
