package DataTypes;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int pouredWater = 0;

        for (int i = 0; i < n; i++) {
            int quantityWater = Integer.parseInt(scanner.nextLine());
            pouredWater += quantityWater;

            if (pouredWater >= 255) {
                System.out.println("Insufficient capacity!");
                pouredWater -= quantityWater;
            }
        }
        System.out.println(pouredWater);
    }
}
