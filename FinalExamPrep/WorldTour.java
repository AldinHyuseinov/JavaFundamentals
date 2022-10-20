package FinalExamPrep;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder tour = new StringBuilder(stops);

        while (!command.equals("Travel")) {
            String[] commandArr = command.split(":");

            switch (commandArr[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commandArr[1]);

                    if (index >= 0 && index < tour.length()) {
                        tour.insert(index, commandArr[2]);
                    }
                    System.out.println(tour);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArr[1]);
                    int endIndex = Integer.parseInt(commandArr[2]);

                    if (startIndex >= 0 && startIndex < tour.length() && endIndex >= 0 && endIndex < tour.length()) {
                        tour.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(tour);
                    break;
                case "Switch":
                    tour.replace(tour.indexOf(commandArr[1]), tour.indexOf(commandArr[1]) + commandArr[1].length(), commandArr[2]);
                    System.out.println(tour);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + tour);
    }
}
