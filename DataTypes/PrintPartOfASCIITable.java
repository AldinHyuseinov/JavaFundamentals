package DataTypes;

import java.util.Scanner;

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstIndex = Integer.parseInt(scanner.nextLine());
        int secIndex = Integer.parseInt(scanner.nextLine());

        for (int i = firstIndex; i <= secIndex; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}
