package Exam;

import java.util.Scanner;

public class TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitPerDay = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int competitionBiscuits = Integer.parseInt(scanner.nextLine());
        double total = 0;

        for (int i = 1; i <= 30; i++) {

            if (i % 3 == 0) {
                double lessProduce = Math.floor((biscuitPerDay - biscuitPerDay * 0.25) * workers);
                total += lessProduce;
            } else {
                total += Math.floor(biscuitPerDay * workers);
            }
        }

        System.out.printf("You have produced %.0f biscuits for the past month.%n", total);
        double difference = (total - competitionBiscuits) / competitionBiscuits * 100;

        if (difference >= 0) {
            System.out.printf("You produce %.2f percent more biscuits.%n", difference);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", Math.abs(difference));
        }
    }
}
