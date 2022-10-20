package FinalExamPrep;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder decode = new StringBuilder(message);

        while (!command.equals("Decode")) {
            String[] commandArr = command.split("\\|");

            switch (commandArr[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandArr[1]);
                    decode.append(decode, 0, numberOfLetters);
                    decode.delete(0, numberOfLetters);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArr[1]);
                    decode.insert(index, commandArr[2]);
                    break;
                case "ChangeAll":
                    String change = decode.toString().replace(commandArr[1], commandArr[2]);
                    decode.setLength(0);
                    decode.append(change);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + decode);
    }
}
