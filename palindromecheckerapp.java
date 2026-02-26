// File: PalindromeCheckerApp.java
import java.util.*;

public class PalindromeCheckerApp {

    // UC2: Hardcoded / simple string palindrome
    public static boolean isSimplePalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // UC9/10: Recursive palindrome check (ignores spaces & case)
    public static boolean isRecursivePalindrome(String input, int start, int end) {
        if (start >= end) return true;
        if (input.charAt(start) != input.charAt(end)) return false;
        return isRecursivePalindrome(input, start + 1, end - 1);
    }

    // UC11: Object-oriented palindrome service
    static class PalindromeChecker {
        private String text;
        public PalindromeChecker(String text) { this.text = text; }
        public boolean checkPalindrome() {
            String normalized = text.replaceAll("\\s+", "").toLowerCase();
            int start = 0, end = normalized.length() - 1;
            while (start < end) {
                if (normalized.charAt(start) != normalized.charAt(end)) return false;
                start++;
                end--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();

        // Example 1: Simple check
        System.out.println("Simple palindrome check:");
        System.out.println(isSimplePalindrome(input) ? "Palindrome!" : "Not a palindrome.");

        // Example 2: Recursive & normalized check
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        System.out.println("Recursive (case & space ignored) check:");
        System.out.println(isRecursivePalindrome(normalized, 0, normalized.length() - 1) ? "Palindrome!" : "Not a palindrome.");

        // Example 3: Using Object-Oriented PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker(input);
        System.out.println("Object-Oriented check:");
        System.out.println(checker.checkPalindrome() ? "Palindrome!" : "Not a palindrome.");

        sc.close();
    }
}