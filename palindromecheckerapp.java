
// File: UseCase9PalindromeCheckerApp.java
import java.util.Scanner;

public class palindromecheckerapp {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: if start >= end, we have checked all pairs
        if (start >= end) {
            return true;
        }

        // Check first and last character
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for the substring inside
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = sc.nextLine();

        // Remove spaces and make lowercase for uniform checking
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Call recursive method
        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        sc.close();
    }
}