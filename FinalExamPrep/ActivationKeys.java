package FinalExamPrep;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder(key);

        while (!command.equals("Generate")) {
            String[] commandArr = command.split(">>>");

            switch (commandArr[0]) {
                case "Contains":
                    int index = activationKey.indexOf(commandArr[1]);

                    if (index != -1) {
                        System.out.println(activationKey + " contains " + commandArr[1]);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(commandArr[2]);
                    int endIndex = Integer.parseInt(commandArr[3]);
                    String flip;

                    if (commandArr[1].equals("Upper")) {
                        flip = activationKey.substring(startIndex, endIndex).toUpperCase();
                    } else {
                        flip = activationKey.substring(startIndex, endIndex).toLowerCase();
                    }
                    activationKey.delete(startIndex, endIndex);
                    activationKey.insert(startIndex, flip);
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int firstIndex = Integer.parseInt(commandArr[1]);
                    int lastIndex = Integer.parseInt(commandArr[2]);
                    activationKey.delete(firstIndex, lastIndex);
                    System.out.println(activationKey);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
