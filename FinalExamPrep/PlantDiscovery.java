package FinalExamPrep;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantAndRarity = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPlants; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            double rarity = Double.parseDouble(plantInfo[1]);

            if (!plantAndRarity.containsKey(plantInfo[0])) {
                plantAndRarity.put(plantInfo[0], new ArrayList<>());
                plantAndRarity.get(plantInfo[0]).add(rarity);
            } else {
                plantAndRarity.get(plantInfo[0]).set(0, rarity);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {
            String[] commandArr = command.split(" ");

            if (!plantAndRarity.containsKey(commandArr[1])) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }

            switch (commandArr[0]) {
                case "Rate:":
                    plantAndRarity.get(commandArr[1]).add(Double.parseDouble(commandArr[3]));
                    break;
                case "Update:":
                    plantAndRarity.get(commandArr[1]).set(0, Double.parseDouble(commandArr[3]));
                    break;
                case "Reset:":
                    plantAndRarity.get(commandArr[1]).subList(1, plantAndRarity.get(commandArr[1]).size()).clear();
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, List<Double>> entry : plantAndRarity.entrySet()) {
            double avg = 0;

            for (int i = 1; i < entry.getValue().size(); i++) {
                avg += entry.getValue().get(i);
            }
            avg /= entry.getValue().size() - 1;

            if (Double.isNaN(avg)) {
                avg = 0.00;
            }
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), avg);
        }
    }
}
