package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int rotNum = Integer.parseInt(scanner.nextLine());
        Collections.rotate(numList, -rotNum);
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
