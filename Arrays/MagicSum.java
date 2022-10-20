package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < intList.size(); i++) {
            for (int j = i + 1; j < intList.size(); j++) {

                if (intList.get(i) + intList.get(j) == num) {
                    System.out.printf("%d %d%n", intList.get(i), intList.get(j));
                }
            }
        }
    }
}