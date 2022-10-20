package FinalExamPrep;

import java.util.*;

public class SantaNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> children = new TreeMap<>();
        Map<String, Integer> presents = new LinkedHashMap<>();

        while (!command.equals("END")) {
            String[] commandArr = command.split("->");

            if (commandArr[0].equals("Remove")) {
                children.remove(commandArr[1]);
            } else {
                int amount = Integer.parseInt(commandArr[2]);

                if (!children.containsKey(commandArr[0])) {
                    children.put(commandArr[0], amount);
                } else {
                    children.put(commandArr[0], children.get(commandArr[0]) + amount);
                }

                if (!presents.containsKey(commandArr[1])) {
                    presents.put(commandArr[1], amount);
                } else {
                    presents.put(commandArr[1], presents.get(commandArr[1]) + amount);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Children:");
        children.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(kid -> System.out.println(kid.getKey() + " -> " + kid.getValue()));
        System.out.println("Presents:");
        presents.forEach((gift, amount) -> System.out.println(gift + " -> " + amount));
    }
}
