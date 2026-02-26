// File: PalindromeCheckerApp.java
import java.util.*;

public class PalindromeCheckerApp {

    // ---------- UC12: Strategy Pattern ----------
    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    // Stack-based strategy
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.replaceAll("\\s+", "").toLowerCase();
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) stack.push(c);
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    // Deque-based strategy
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String input) {
            input = input.replaceAll("\\s+", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) deque.addLast(c);
            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    // Context class for strategy
    static class PalindromeContext {
        private PalindromeStrategy strategy;
        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }
        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }
        public boolean executeStrategy(String input) {
            return strategy.isPalindrome(input);
        }
    }

    // ---------- Existing Methods (optional for UC2–UC11) ----------
    public static boolean isSimplePalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check palindrome:");
        String input = sc.nextLine();

        // Example: Using Strategy Pattern
        PalindromeContext context;

        System.out.println("\nUsing StackStrategy:");
        context = new PalindromeContext(new StackStrategy());
        System.out.println(context.executeStrategy(input) ? "Palindrome!" : "Not a palindrome.");

        System.out.println("\nUsing DequeStrategy:");
        context.setStrategy(new DequeStrategy());
        System.out.println(context.executeStrategy(input) ? "Palindrome!" : "Not a palindrome.");

        // Optional: Simple direct check
        System.out.println("\nSimple direct check:");
        System.out.println(isSimplePalindrome(input) ? "Palindrome!" : "Not a palindrome.");

        sc.close();
    }
}