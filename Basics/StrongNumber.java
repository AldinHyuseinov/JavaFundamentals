package Basics;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int factorial = 1;
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';

            for (int j = 1; j <= digit; j++) {
                factorial *= j;
            }
            sum += factorial;
            factorial = 1;
        }
        int numb = Integer.parseInt(num);

        if (sum == numb) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}