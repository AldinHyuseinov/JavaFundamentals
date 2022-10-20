package Maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        Map<Character, Integer> charCount = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) != ' ') {

                if (!charCount.containsKey(input.charAt(i))) {
                    charCount.put(input.charAt(i), 1);
                } else {
                    charCount.put(input.charAt(i), charCount.get(input.charAt(i)) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}