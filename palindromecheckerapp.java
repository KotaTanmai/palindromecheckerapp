<<<<<<< HEAD
=======
import java.util.Scanner;
>>>>>>> main

// File: UseCase10PalindromeCheckerApp.java
import java.util.Scanner;

public class palindromecheckerapp {

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

<<<<<<< HEAD
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
=======
    // ================= UC8: Linked List Palindrome Check =================
    public static boolean isLinkedListPalindrome(String input) {

        if (input == null || input.length() == 0)
            return true;

        // Convert String to Linked List
        Node head = new Node(input.charAt(0));
        Node current = head;

        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        // Find middle using Fast & Slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null;
        Node next;

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Compare both halves
        Node firstHalf = head;
        Node secondHalf = prev;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
>>>>>>> main
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