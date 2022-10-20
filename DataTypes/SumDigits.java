package DataTypes;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
          int digit = str.charAt(i) - '0';
          sum += digit;
        }
        System.out.println(sum);
    }
}
