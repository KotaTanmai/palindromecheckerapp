import java.util.*;

public class PalindromeCheckerApp {

    // Method 1: Reverse String Method
    public static boolean reverseMethod(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Method 2: Char Array Method
    public static boolean charArrayMethod(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Method 3: Stack Method
    public static boolean stackMethod(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("\n--- Performance Comparison ---");

        long start1 = System.nanoTime();
        boolean result1 = reverseMethod(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        long start2 = System.nanoTime();
        boolean result2 = charArrayMethod(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        long start3 = System.nanoTime();
        boolean result3 = stackMethod(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("Reverse Method: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Char Array Method: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Stack Method: " + result3 + " | Time: " + time3 + " ns");

        scanner.close();
    }
}