package FinalExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher matchDigits = digitPattern.matcher(text);
        long coolThreshold = 1;

        while (matchDigits.find()) {
            coolThreshold *= Long.parseLong(matchDigits.group());
        }

        System.out.println("Cool threshold: " + coolThreshold);

        Pattern pattern = Pattern.compile("(::|\\*\\*)([A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> coolEmojis = new ArrayList<>();
        int count = 0;

        while (matcher.find()) {
            count++;
            String emoji = matcher.group(2);
            long coolness = 0;

            for (int i = 0; i < emoji.length(); i++) {
                coolness += emoji.charAt(i);
            }

            if (coolness >= coolThreshold) {
                coolEmojis.add(matcher.group());
            }
        }
        System.out.println(count + " emojis found in the text. The cool ones are:");

        if (!coolEmojis.isEmpty()) {

            for (String coolEmoji : coolEmojis) {
                System.out.println(coolEmoji);
            }
        }
    }
}
