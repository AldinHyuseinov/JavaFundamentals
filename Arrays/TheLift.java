package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < lift.length; i++) {
            lift[i] += 4;
            waitingPeople -= 4;

            if (waitingPeople < 0) {
                int difference = waitingPeople + lift[i];
                waitingPeople += difference;
                lift[i] -= difference;
            }

            if (lift[i] > 4) {
                int difference = lift[i] - 4;
                lift[i] -= difference;
                waitingPeople += difference;
            } else if (lift[i] < 4) {
                i--;
            }


        }
    }
}
