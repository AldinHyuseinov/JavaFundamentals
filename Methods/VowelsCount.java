package Methods;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine().toLowerCase();
        vowelCount(str);
    }

    public static void vowelCount(String string) {
        int count = 0;

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o' || string.charAt(i) == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
