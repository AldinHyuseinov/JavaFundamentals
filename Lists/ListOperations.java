package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] input = command.split(" ");

            switch (input[0]) {
                case "Add":
                    intList.add(Integer.parseInt(input[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(input[2]);

                    if (index < 0 || index >= intList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        intList.add(index, Integer.parseInt(input[1]));
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(input[1]);

                    if (removeIndex < 0 || removeIndex >= intList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        intList.remove(removeIndex);
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(input[2]);

                    if (input[1].equals("left")) {
                        Collections.rotate(intList, -count);
                    } else {
                        Collections.rotate(intList, count);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(intList.toString().replaceAll("[\\[\\],]", ""));
    }
}
