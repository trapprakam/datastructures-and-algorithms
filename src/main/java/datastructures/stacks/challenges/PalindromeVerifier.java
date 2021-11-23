package main.java.datastructures.stacks.challenges;

import java.util.LinkedList;

public class PalindromeVerifier {

    public static boolean checkForPalindrome(String possiblePalindrome) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(possiblePalindrome.length());
        String lowercase = possiblePalindrome.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }
        StringBuilder reverseString = new StringBuilder(stack.size());
        while (!stack.isEmpty()){
            reverseString.append(stack.pop());
        }
        return reverseString.toString().equals(stringNoPunctuation.toString());
    }

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }
}
