package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < intList.size(); i++) {
            int leftSum = intList.subList(0, i).stream().mapToInt(Integer::intValue).sum();
            int rightSum = intList.subList(i + 1, intList.size()).stream().mapToInt(Integer::intValue).sum();

            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
