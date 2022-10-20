package Methods;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char character1 = scanner.nextLine().charAt(0);
        char character2 = scanner.nextLine().charAt(0);
        charsInRange(character1, character2);
    }

    public static void charsInRange(char chr1, char chr2) {
        int count = 0;

        for (char i = chr1; i < chr2; i++) {
            count++;

            if (count == 1) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}