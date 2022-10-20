package FinalExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        StringBuilder message = new StringBuilder();
        Pattern pattern = Pattern.compile("[^@!:>-]*@(?<name>[A-Za-z]+)[^@!:>-]*!(?<behavior>[GN])![^@!:>-]*");
        List<String> goodKids = new ArrayList<>();

        while (!command.equals("end")) {

            for (int i = 0; i < command.length(); i++) {
                char symbol = (char) (command.charAt(i) - key);
                message.append(symbol);
            }
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {

                if (matcher.group("behavior").equals("G")) {
                    goodKids.add(matcher.group("name"));
                }
            }
            message.setLength(0);
            command = scanner.nextLine();
        }
        goodKids.forEach(System.out::println);
    }
}
