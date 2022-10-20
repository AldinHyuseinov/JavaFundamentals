package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> peopleList = new ArrayList<>();

        for (int i = 0; i < amountOfCommands; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (input[2].equals("going!")) {

                if (!peopleList.contains(input[0])) {
                    peopleList.add(input[0]);
                } else {
                    System.out.println(input[0] + " is already in the list!");
                }
            } else {

                if (peopleList.contains(input[0])) {
                    peopleList.remove(input[0]);
                } else {
                    System.out.println(input[0] + " is not in the list!");
                }
            }
        }
        for (String name : peopleList) {
            System.out.println(name);
        }
    }
}
