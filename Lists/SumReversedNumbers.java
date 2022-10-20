package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumReversedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int sum = 0;

        for (String s : numbers) {
            String reversedNum = new StringBuffer(s).reverse().toString();
            int number = Integer.parseInt(reversedNum);
            sum += number;
        }
        System.out.println(sum);
    }
}
