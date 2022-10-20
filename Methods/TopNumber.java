package Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopNumber {
    public static int rules = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if (num < 17) {
            return;
        }

        for (int i = 17; i <= num; i++) {
            String numInString = String.valueOf(i);
            digitsSum(numInString);
            oddDigit(numInString);

            if (TopNumber.rules == 2) {
                System.out.println(i);
            }
            TopNumber.rules = 0;
        }
    }

    public static void digitsSum(String numInString) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numInString.length(); i++) {
            numbers.add((int) numInString.charAt(i));
        }
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        if (sum % 8 == 0) {
            TopNumber.rules++;
        }
    }

    public static void oddDigit(String numInString) {
        for (int i = 0; i < numInString.length(); i++) {

            if (Integer.parseInt(String.valueOf(numInString.charAt(i))) % 2 != 0) {
                TopNumber.rules++;
                break;
            }
        }
    }
}
