package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> topIntegers = new ArrayList<>();

        for (int i = 0; i < intList.size(); i++) {
            boolean isTopInteger = true;

            for (int j = i + 1; j < intList.size(); j++) {

                if (intList.get(i) <= intList.get(j)) {
                    isTopInteger = false;

                    break;
                }
            }

            if (isTopInteger) {
                topIntegers.add(intList.get(i));
            }
        }
        System.out.println(topIntegers.toString().replaceAll("[\\[\\],]", ""));
    }
}
