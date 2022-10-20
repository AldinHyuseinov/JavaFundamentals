package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class JumpAround {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentPosition = numbers[0];
        int sum = currentPosition;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {

            if (currentPosition >= 0 && currentPosition < numbers.length) {
                index = numbers[currentPosition];
                currentPosition += numbers[currentPosition];
            } else {
                currentPosition -= index;
                currentPosition -= index;
            }
        }
    }
}
