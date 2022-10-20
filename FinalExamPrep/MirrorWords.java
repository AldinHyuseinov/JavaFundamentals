package FinalExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        int wordPairs = 0;
        List<String> mirrorWords = new ArrayList<>();

        while (matcher.find()) {
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");
            wordPairs++;

            String wordTwoReversed = new StringBuffer(wordTwo).reverse().toString();

            if (wordTwoReversed.equals(wordOne)) {
                mirrorWords.add(wordOne + " <=> " + wordTwo);
            }
        }

        if (wordPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(wordPairs + " word pairs found!");
        }

        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}
