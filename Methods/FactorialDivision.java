package Methods;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        double factorialDivision = firstFactorial(num1) * 1.0 / secFactorial(num2);
        System.out.printf("%.2f", factorialDivision);
    }

    public static int firstFactorial(int num1) {

        if (num1 == 0) {
            return 1;
        }
        int fact1 = 1;

        for (int i = 1; i <= num1; i++) {
            fact1 *= i;
        }
        return fact1;
    }

    public static int secFactorial(int num2) {

        if (num2 == 0) {
            return 1;
        }
        int fact2 = 1;

        for (int i = 1; i <= num2; i++) {
            fact2 *= i;
        }
        return fact2;
    }
}
