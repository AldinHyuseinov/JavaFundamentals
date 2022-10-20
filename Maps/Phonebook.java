package Maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, String> phoneBook = new TreeMap<>();

        while (!command.equals("END")) {
            String[] commandArr = command.split(" ");

            if (commandArr[0].equals("ListAll")) {

                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
            } else if (commandArr[0].equals("A")) {
                phoneBook.put(commandArr[1], commandArr[2]);
            } else {

                if (phoneBook.containsKey(commandArr[1])) {
                    System.out.println(commandArr[1] + " -> " + phoneBook.get(commandArr[1]));
                } else {
                    System.out.println("Contact " + commandArr[1] + " does not exist.");
                }
            }
            command = scanner.nextLine();
        }
    }
}