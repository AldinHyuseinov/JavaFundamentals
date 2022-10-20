package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int[] bombAndPower = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numList.size(); i++) {
            int indexOfBomb = numList.indexOf(bombAndPower[0]);

            if (indexOfBomb == -1) {
                break;
            }
            leftDetonation(numList, indexOfBomb, bombAndPower[1]);
            indexOfBomb = numList.indexOf(bombAndPower[0]);
            rightDetonation(numList, indexOfBomb, bombAndPower[1]);
            numList.remove((Integer) bombAndPower[0]);
        }
        int sum = numList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

    public static void leftDetonation(List<Integer> numList, int index, int power) {
        for (int i = index - 1; i >= 0; i--) {
            numList.remove(i);
            power--;

            if (power <= 0) {
                break;
            }
        }
    }

    public static void rightDetonation(List<Integer> numList, int index, int power) {
        for (int i = index + 1; i < numList.size(); i++) {
            numList.remove(i);
            power--;
            i--;

            if (power <= 0) {
                break;
            }
        }
    }
}
