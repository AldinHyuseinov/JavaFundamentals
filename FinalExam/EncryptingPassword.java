package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputCount = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("(.+)>(?<first>\\d{3})\\|(?<sec>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<\\1");
        StringBuilder encryptedPassword = new StringBuilder();

        for (int i = 0; i < inputCount; i++) {
            String password = scanner.nextLine();
            Matcher matcher = pattern.matcher(password);

            if (matcher.find()) {
                encryptedPassword.append(matcher.group("first")).append(matcher.group("sec")).append(matcher.group("third")).append(matcher.group("fourth"));
                System.out.println("Password: " + encryptedPassword);
                encryptedPassword.setLength(0);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
