package FinalExamPrep;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder actualMessage = new StringBuilder(message);

        while (!command.equals("Reveal")) {
            String[] commandArr = command.split(":\\|:");

            switch (commandArr[0]) {
                case "InsertSpace":
                    actualMessage.insert(Integer.parseInt(commandArr[1]), " ");
                    System.out.println(actualMessage);
                    break;
                case "Reverse":
                    int index = actualMessage.indexOf(commandArr[1]);

                    if (index != -1) {
                        String reversed = new StringBuffer(actualMessage.substring(index, commandArr[1].length() + index)).reverse().toString();
                        actualMessage.delete(index, commandArr[1].length() + index);
                        actualMessage.append(reversed);
                        System.out.println(actualMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String replace = actualMessage.toString().replace(commandArr[1], commandArr[2]);
                    actualMessage.setLength(0);
                    actualMessage.append(replace);
                    System.out.println(actualMessage);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + actualMessage);
    }
}
