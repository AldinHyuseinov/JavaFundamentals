package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCap = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] input = command.split(" ");

            if (input[0].equals("Add")) {
                wagons.add(Integer.parseInt(input[1]));
            } else {
                int passengers = Integer.parseInt(input[0]);

                for (int i = 0; i < wagons.size(); i++) {

                    if (wagons.get(i) + passengers <= maxCap) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
