package FinalExamPrep;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<itemName>[A-Za-z ]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<nutrition>[1-9][0-9]{0,4}|10000|0)\\1");
        Matcher matcher = pattern.matcher(text);
        int total = 0;

        while (matcher.find()) {
            total += Integer.parseInt(matcher.group("nutrition"));
        }
        total /= 2000;
        System.out.println("You have food to last you for: " + total + " days!");
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", matcher.group("itemName"), matcher.group("expirationDate"), matcher.group("nutrition"));
        }
    }
}
