package main.java.datastructures.queues.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromeVerifier {

    public static boolean checkForPalindrome(String possiblePalindrome) {
        LinkedList<Character> stack = new LinkedList<>();
        Queue<Character> stringNoPunctuationQueue = new LinkedList<>();
        String lowercase = possiblePalindrome.toLowerCase();
        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuationQueue.add(c);
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if (!stack.pop().equals(stringNoPunctuationQueue.remove())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't nod"));
    }
}
