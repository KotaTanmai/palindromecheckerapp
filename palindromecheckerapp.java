
// File: UseCase10PalindromeCheckerApp.java
import java.util.Scanner;

public class palindromecheckerapp {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome (ignores spaces & case):");
        String input = sc.nextLine();

        // Normalize string: remove spaces & convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Check palindrome
        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        sc.close();
    }
}