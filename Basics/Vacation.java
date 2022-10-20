package Basics;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0;

        switch (day) {
            case "Friday":

                if (type.equals("Students")) {
                    totalPrice += amount * 8.45;

                    if (amount >= 30) {
                        totalPrice -= totalPrice * 0.15;
                    }
                } else if (type.equals("Business")) {

                    if (amount >= 100) {
                        amount -= 10;
                    }
                    totalPrice += amount * 10.90;
                } else {
                    totalPrice += amount * 15;

                    if (amount >= 10 && amount <= 20) {
                        totalPrice -= totalPrice * 0.05;
                    }
                }
                break;
            case "Saturday":

                if (type.equals("Students")) {
                    totalPrice += amount * 9.80;

                    if (amount >= 30) {
                        totalPrice -= totalPrice * 0.15;
                    }
                } else if (type.equals("Business")) {

                    if (amount >= 100) {
                        amount -= 10;
                    }
                    totalPrice += amount * 15.60;
                } else {
                    totalPrice += amount * 20;

                    if (amount >= 10 && amount <= 20) {
                        totalPrice -= totalPrice * 0.05;
                    }
                }
                break;
            case "Sunday":
                if (type.equals("Students")) {
                    totalPrice += amount * 10.46;

                    if (amount >= 30) {
                        totalPrice -= totalPrice * 0.15;
                    }
                } else if (type.equals("Business")) {

                    if (amount >= 100) {
                        amount -= 10;
                    }
                    totalPrice += amount * 16;
                } else {
                    totalPrice += amount * 22.50;

                    if (amount >= 10 && amount <= 20) {
                        totalPrice -= totalPrice * 0.05;
                    }
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}