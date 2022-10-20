package Methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        smallestNum(num1, num2, num3);
    }

    public static void smallestNum(int n, int n2, int n3) {
        if (n < n2 && n < n3) {
            System.out.println(n);
        } else if (n2 < n && n2 < n3) {
            System.out.println(n2);
        } else {
            System.out.println(n3);
        }
    }
}