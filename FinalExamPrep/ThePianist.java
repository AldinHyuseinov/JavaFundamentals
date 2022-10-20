package FinalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPieces = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, String>> pieceAndComposer = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPieces; i++) {
            String[] input = scanner.nextLine().split("\\|");
            pieceAndComposer.putIfAbsent(input[0], new LinkedHashMap<>());
            pieceAndComposer.get(input[0]).putIfAbsent(input[1], input[2]);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commandArr = command.split("\\|");

            switch (commandArr[0]) {
                case "Add":

                    if (pieceAndComposer.containsKey(commandArr[1])) {
                        System.out.println(commandArr[1] + " is already in the collection!");
                    } else {
                        pieceAndComposer.putIfAbsent(commandArr[1], new LinkedHashMap<>());
                        pieceAndComposer.get(commandArr[1]).put(commandArr[2], commandArr[3]);
                        System.out.printf("%s by %s in %s added to the collection!%n", commandArr[1], commandArr[2], commandArr[3]);
                    }
                    break;
                case "Remove":

                    if (pieceAndComposer.containsKey(commandArr[1])) {
                        pieceAndComposer.remove(commandArr[1]);
                        System.out.println("Successfully removed " + commandArr[1] + "!");
                    } else {
                        System.out.println("Invalid operation! " + commandArr[1] + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    boolean noExist = true;

                    for (Map.Entry<String, Map<String, String>> entry : pieceAndComposer.entrySet()) {

                        if (entry.getKey().equals(commandArr[1])) {

                            for (String s : entry.getValue().keySet()) {
                                pieceAndComposer.get(commandArr[1]).put(s, commandArr[2]);
                            }
                            System.out.println("Changed the key of " + commandArr[1] + " to " + commandArr[2] + "!");
                            noExist = false;
                            break;
                        }
                    }

                    if (noExist) {
                        System.out.println("Invalid operation! " + commandArr[1] + " does not exist in the collection.");
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, String>> entry : pieceAndComposer.entrySet()) {

            for (Map.Entry<String, String> pieces : entry.getValue().entrySet()) {
                System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), pieces.getKey(), pieces.getValue());
            }
        }
    }
}
