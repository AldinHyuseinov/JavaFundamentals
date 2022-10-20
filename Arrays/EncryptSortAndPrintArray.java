package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        List<Integer> sums = new ArrayList<>();

        for (int i = 0; i < numberOfNames; i++) {
            String name = scanner.nextLine();

            for (int j = 0; j < name.length(); j++) {

                if (name.charAt(j) == 'a' || name.charAt(j) == 'e' || name.charAt(j) == 'i' || name.charAt(j) == 'o' || name.charAt(j) == 'u' || name.charAt(j) == 'A' || name.charAt(j) == 'E' || name.charAt(j) == 'I' || name.charAt(j) == 'O' || name.charAt(j) == 'U') {
                    sum += name.charAt(j) * name.length();
                } else {
                    sum += name.charAt(j) / name.length();
                }
            }
            sums.add(sum);
            sum = 0;
        }
        sums.stream().sorted().forEach(System.out::println);
    }
}
