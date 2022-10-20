package FinalExamPrep;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder password = new StringBuilder(text);

        while (!command.equals("Done")) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "TakeOdd":
                    StringBuilder oddChars = new StringBuilder();

                    for (int i = 0; i < password.length(); i++) {

                        if (i % 2 != 0) {
                            oddChars.append(password.charAt(i));
                        }
                    }
                    System.out.println(oddChars);
                    password.setLength(0);
                    password.append(oddChars);
                    oddChars.setLength(0);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commandArr[1]);
                    int length = Integer.parseInt(commandArr[2]);
                    password.delete(index, index + length);
                    System.out.println(password);
                    break;
                case "Substitute":
                    int indexOf = password.indexOf(commandArr[1]);

                    if (indexOf != -1) {
                        String replace = password.toString().replace(commandArr[1], commandArr[2]);
                        password.setLength(0);
                        password.append(replace);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
