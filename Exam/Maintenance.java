package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Maintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        int blacklistedNames = 0;
        int lostNames = 0;

        while (!command.equals("Report")) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "Blacklist":

                    if (names.contains(commandArr[1])) {
                        int index = names.indexOf(commandArr[1]);
                        System.out.println(names.get(index) + " was blacklisted.");
                        names.set(index, "Blacklisted");
                        blacklistedNames++;
                    } else {
                        System.out.println(commandArr[1] + " was not found.");
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(commandArr[1]);

                    if (index >= 0 && index < names.size() && !names.get(index).equals("Blacklisted") && !names.get(index).equals("Lost")) {
                        System.out.println(names.get(index) + " was lost due to an error.");
                        names.set(index, "Lost");
                        lostNames++;
                    }
                    break;
                case "Change":
                    int changeIndex = Integer.parseInt(commandArr[1]);

                    if (changeIndex >= 0 && changeIndex < names.size()) {
                        System.out.println(names.get(changeIndex) + " changed his username to " + commandArr[2] + ".");
                        names.set(changeIndex, commandArr[2]);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Blacklisted names: " + blacklistedNames);
        System.out.println("Lost names: " + lostNames);
        System.out.println(names.toString().replaceAll("[\\[\\],]", ""));
    }
}
