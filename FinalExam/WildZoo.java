package FinalExam;

import java.util.*;

public class WildZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> animalData = new LinkedHashMap<>();
        Map<String, List<String>> areas = new LinkedHashMap<>();

        while (!command.equals("EndDay")) {
            String[] commandArr = command.split(" ");
            String[] animals = commandArr[1].split("-");

            if (commandArr[0].equals("Add:")) {
                int neededFood = Integer.parseInt(animals[1]);

                if (!animalData.containsKey(animals[0])) {
                    animalData.put(animals[0], neededFood);

                    if (!areas.containsKey(animals[2])) {
                        areas.put(animals[2], new ArrayList<>());
                    }
                    areas.get(animals[2]).add(animals[0]);
                } else {
                    animalData.put(animals[0], animalData.get(animals[0]) + neededFood);
                }
            } else {
                int food = Integer.parseInt(animals[1]);

                if (animalData.containsKey(animals[0])) {
                    animalData.put(animals[0], animalData.get(animals[0]) - food);

                    if (animalData.get(animals[0]) <= 0) {
                        animalData.remove(animals[0]);

                        for (Map.Entry<String, List<String>> entry : areas.entrySet()) {

                            for (int i = 0; i < entry.getValue().size(); i++) {

                                if (entry.getValue().get(i).equals(animals[0])) {
                                    entry.getValue().remove(i);
                                    break;
                                }
                            }
                        }
                        System.out.println(animals[0] + " was successfully fed");
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Animals:");

        for (Map.Entry<String, Integer> entry : animalData.entrySet()) {
            System.out.println(" " + entry.getKey() + " -> " + entry.getValue() + "g");
        }
        System.out.println("Areas with hungry animals:");

        for (Map.Entry<String, List<String>> entry : areas.entrySet()) {

            if (!entry.getValue().isEmpty()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().size());
            }
        }
    }
}
