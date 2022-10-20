package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numList.size(); i++) {

            if (numList.get(i) % 2 != 0) {
                numList.remove(i);
                i--;
            }
        }

        for (int i = 0; i < numList.size(); i++) {
            int num = numList.get(i);
            numList.remove(i);

            if (numList.isEmpty()) {
                numList.add(num - 1);
                break;
            }

            double avg = Math.ceil(numList.stream().mapToInt(Integer::intValue).average().getAsDouble());

            if (num > avg) {
                numList.add(i, num + 1);
            } else {
                numList.add(i, num - 1);
            }
        }
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
