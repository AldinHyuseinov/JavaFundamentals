package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String command = scanner.nextLine();
        StringBuilder changePassword = new StringBuilder(password);
        Pattern digitsAndLetters = Pattern.compile("\\w");
        Pattern uppercaseLetters = Pattern.compile("[A-Z]");
        Pattern lowercaseLetters = Pattern.compile("[a-z]");
        Pattern digits = Pattern.compile("\\d");
        Matcher matcher;

        while (!command.equals("Complete")) {
            String[] commandArr = command.split("\\s+");

            switch (commandArr[0]) {
                case "Make":
                    int index = Integer.parseInt(commandArr[2]);

                    if (index >= 0 && index < changePassword.length()) {
                        String letter;

                        if (commandArr[1].equals("Upper")) {
                            letter = Character.toString(changePassword.charAt(index)).toUpperCase();
                            changePassword.deleteCharAt(index);
                            changePassword.insert(index, letter);
                        } else if (commandArr[1].equals("Lower")) {
                            letter = Character.toString(changePassword.charAt(index)).toLowerCase();
                            changePassword.deleteCharAt(index);
                            changePassword.insert(index, letter);
                        }
                    }
                    System.out.println(changePassword);
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(commandArr[1]);

                    if (insertIndex >= 0 && insertIndex < changePassword.length()) {
                        changePassword.insert(insertIndex, commandArr[2]);
                    }
                    System.out.println(changePassword);
                    break;
                case "Replace":
                    int charIndex = changePassword.indexOf(commandArr[1]);

                    if (charIndex != -1) {
                        int charValue = commandArr[1].charAt(0) + Integer.parseInt(commandArr[2]);

                        if (charValue >= 0 && charValue <= 127) {
                            char newSymbol = (char) charValue;
                            String replace = changePassword.toString().replace(commandArr[1].charAt(0), newSymbol);
                            changePassword.setLength(0);
                            changePassword.append(replace);
                        }
                    }
                    System.out.println(changePassword);
                    break;
                case "Validation":

                    if (changePassword.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    matcher = digitsAndLetters.matcher(changePassword);

                    if (!matcher.find()) {
                        System.out.println("Password must consist only of letters, digits and _!");
                    }
                    matcher = uppercaseLetters.matcher(changePassword);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    matcher = lowercaseLetters.matcher(changePassword);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    matcher = digits.matcher(changePassword);

                    if (!matcher.find()) {
                        System.out.println("Password must consist at least one digit!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
