package FinalExamPrep;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<Integer>> cities = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String[] commandArr = command.split("\\|\\|");
            int population = Integer.parseInt(commandArr[1]);
            int gold = Integer.parseInt(commandArr[2]);

            if (!cities.containsKey(commandArr[0])) {
                cities.put(commandArr[0], new ArrayList<>());
                cities.get(commandArr[0]).add(population);
                cities.get(commandArr[0]).add(gold);
            } else {
                cities.get(commandArr[0]).set(0, cities.get(commandArr[0]).get(0) + population);
                cities.get(commandArr[0]).set(1, cities.get(commandArr[0]).get(1) + gold);
            }
            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] events = command.split("=>");

            if (events[0].equals("Plunder")) {
                cities.get(events[1]).set(0, cities.get(events[1]).get(0) - Integer.parseInt(events[2]));
                cities.get(events[1]).set(1, cities.get(events[1]).get(1) - Integer.parseInt(events[3]));
                System.out.println(events[1] + " plundered! " + events[3] + " gold stolen, " + events[2] + " citizens killed.");

                if (cities.get(events[1]).get(0) <= 0 || cities.get(events[1]).get(1) <= 0) {
                    cities.remove(events[1]);
                    System.out.println(events[1] + " has been wiped off the map!");
                }
            } else {
                int gold = Integer.parseInt(events[2]);

                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    cities.get(events[1]).set(1, cities.get(events[1]).get(1) + gold);
                    System.out.println(gold + " gold added to the city treasury. " + events[1] + " now has " + cities.get(events[1]).get(1) + " gold.");
                }
            }
            command = scanner.nextLine();
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println("Ahoy, Captain! There are " + cities.size() + " wealthy settlements to go to:");

            for (Map.Entry<String, List<Integer>> entry : cities.entrySet()) {
                System.out.println(entry.getKey() + " -> Population: " + entry.getValue().get(0) + " citizens, Gold: " + entry.getValue().get(1) + " kg");
            }
        }
    }
}
