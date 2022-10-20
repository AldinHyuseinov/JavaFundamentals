package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] numArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> takenNumbers = numbers.subList(0, numArr[0]);
        takenNumbers.subList(0, numArr[1]).clear();

        if (takenNumbers.contains(numArr[2])) {
            System.out.println("YES!");
        } else {
            System.out.println("NO!");
        }
    }
}
