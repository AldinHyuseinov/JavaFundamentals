package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] input = command.split(" ");
            int element = Integer.parseInt(input[1]);

            if (input[0].equals("Delete")) {
                intList.removeIf(e -> e == element);
            } else {
                intList.add(Integer.parseInt(input[2]), element);
            }
            command = scanner.nextLine();
        }
        System.out.println(intList.toString().replaceAll("[\\[\\],]", ""));
    }
}
