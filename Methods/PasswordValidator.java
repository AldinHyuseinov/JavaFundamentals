package Methods;

import java.util.Scanner;

public class PasswordValidator {
    public static int validRules = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine().toUpperCase();
        charactersAndValidator(password);

        if (PasswordValidator.validRules == 3) {
            System.out.println("Password is valid");
        }
    }

    public static void charactersAndValidator(String password) {

        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
        } else {
            PasswordValidator.validRules++;
        }
        lettersAndDigits(password);
        digitCount(password);

    }

    public static void lettersAndDigits(String password) {
        boolean isValid = true;

        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) > 0 && password.charAt(i) <= 47 || password.charAt(i) >= 58 && password.charAt(i) <= 64 || password.charAt(i) >= 91 && password.charAt(i) <= 127) {
                System.out.println("Password must consist only of letters and digits");
                isValid = false;
                break;
            }
        }
        if (isValid) {
            PasswordValidator.validRules++;
        }
    }

    public static void digitCount(String password) {
        int digitCount = 0;

        for (int i = 0; i < password.length(); i++) {

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                digitCount++;
            }
        }
        if (digitCount >= 2) {
            PasswordValidator.validRules++;
        } else {
            System.out.println("Password must have at least 2 digits");
        }
    }
}