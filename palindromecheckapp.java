import java.util.Scanner;

class palindromecheckapp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String s = sc.nextLine();

        String rev = "";

        for(int i = s.length()-1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }

        if(s.equals(rev))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}