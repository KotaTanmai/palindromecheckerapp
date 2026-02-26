import java.util.*;

public class PalindromeCheckerApp {

    // ================= UC8: Linked List Node =================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // ================= UC8: Linked List Palindrome =================
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
        Node next = null;

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
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        if (isLinkedListPalindrome(input)) {
            System.out.println(input + " is a Palindrome (Linked List Method)");
        } else {
            System.out.println(input + " is NOT a Palindrome (Linked List Method)");
        }

        scanner.close();
    }
}