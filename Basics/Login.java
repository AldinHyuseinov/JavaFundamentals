package Basics;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String pass = new StringBuffer(username).reverse().toString();
        String input = scanner.nextLine();
        int attempts = 0;

        while (!input.equals(pass)) {

            attempts++;

            if (attempts == 4) {
                System.out.println("User " + username + " blocked!");
                return;
            }
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        System.out.println("User " + username + " logged in.");
    }
}
