package Exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shelfWithBooks = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] commandArr = command.split(" \\| ");

            switch (commandArr[0]) {
                case "Add Book":

                    if (!shelfWithBooks.contains(commandArr[1])) {
                        shelfWithBooks.add(0, commandArr[1]);
                    }
                    break;
                case "Take Book":

                    if (shelfWithBooks.contains(commandArr[1])) {
                        shelfWithBooks.remove(commandArr[1]);
                    }
                    break;
                case "Swap Books":

                    if (shelfWithBooks.contains(commandArr[1]) && shelfWithBooks.contains(commandArr[2])) {
                        int firstBook = shelfWithBooks.indexOf(commandArr[1]);
                        int secBook = shelfWithBooks.indexOf(commandArr[2]);
                        Collections.swap(shelfWithBooks, firstBook, secBook);
                    }
                    break;
                case "Insert Book":

                    if (!shelfWithBooks.contains(commandArr[1])) {
                        shelfWithBooks.add(commandArr[1]);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commandArr[1]);

                    if (index >= 0 && index < shelfWithBooks.size()) {
                        System.out.println(shelfWithBooks.get(index));
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", shelfWithBooks));
    }
}
