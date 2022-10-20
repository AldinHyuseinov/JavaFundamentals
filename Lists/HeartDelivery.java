package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        int positionOfCupid = -1;

        while (!commands.equals("Love!")) {
            String[] jumps = commands.split(" ");
            int jumpLength = Integer.parseInt(jumps[1]);

            for (int i = jumpLength; i >= 0; i--) {

                if (positionOfCupid > neighborhood.size() - 1) {
                    positionOfCupid = 0;
                }

                if (i == 0) {

                    if (neighborhood.get(positionOfCupid) == 0) {
                        System.out.println("Place " + positionOfCupid + " already had Valentine's day.");
                    } else {
                        neighborhood.set(positionOfCupid, neighborhood.get(positionOfCupid) - 2);

                        if (neighborhood.get(positionOfCupid) == 0) {
                            System.out.println("Place " + positionOfCupid + " has Valentine's day.");
                        }
                    }
                }
                positionOfCupid++;
            }
            commands = scanner.nextLine();
        }
        System.out.println("Cupid's last position was " + positionOfCupid + ".");
        int sum = neighborhood.stream().mapToInt(Integer::intValue).sum();

        if (sum == 0) {
            System.out.println("Mission was successful.");
        } else {
            int houseCount = 0;

            for (int i : neighborhood) {

                if (i != 0) {
                    houseCount++;
                }
            }
            System.out.println("Cupid has failed " + houseCount + " places.");
        }
    }
}
