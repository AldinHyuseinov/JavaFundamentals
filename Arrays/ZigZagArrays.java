package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (i % 2 == 0) {
                secList.add(numbers[0]);
                firstList.add(numbers[1]);
            } else {
                firstList.add(numbers[0]);
                secList.add(numbers[1]);
            }
        }
        System.out.println(firstList.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(secList.toString().replaceAll("[\\[\\],]", ""));
    }
}