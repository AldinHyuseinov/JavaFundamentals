package FinalExamPrep;

import java.util.*;

public class NeedForSpeed3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> cars = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCars; i++) {
            String[] carsArr = scanner.nextLine().split("\\|");
            cars.putIfAbsent(carsArr[0], new ArrayList<>());
            cars.get(carsArr[0]).add(Integer.parseInt(carsArr[1]));
            cars.get(carsArr[0]).add(Integer.parseInt(carsArr[2]));
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] commandArr = command.split(" : ");

            switch (commandArr[0]) {
                case "Drive":

                    if (cars.get(commandArr[1]).get(1) < Integer.parseInt(commandArr[3])) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        cars.get(commandArr[1]).set(0, cars.get(commandArr[1]).get(0) + Integer.parseInt(commandArr[2]));
                        cars.get(commandArr[1]).set(1, cars.get(commandArr[1]).get(1) - Integer.parseInt(commandArr[3]));
                        System.out.println(commandArr[1] + " driven for " + commandArr[2] + " kilometers. " + commandArr[3] + " liters of fuel consumed.");
                    }

                    if (cars.get(commandArr[1]).get(0) >= 100000) {
                        cars.remove(commandArr[1]);
                        System.out.println("Time to sell the " + commandArr[1] + "!");
                    }
                    break;
                case "Refuel":
                    int fuel = cars.get(commandArr[1]).get(1);
                    cars.get(commandArr[1]).set(1, cars.get(commandArr[1]).get(1) + Integer.parseInt(commandArr[2]));

                    if (cars.get(commandArr[1]).get(1) > 75) {
                        cars.get(commandArr[1]).set(1, 75);
                        System.out.println(commandArr[1] + " refueled with " + (75 - fuel) + " liters");
                    } else {
                        System.out.println(commandArr[1] + " refueled with " + commandArr[2] + " liters");
                    }
                    break;
                case "Revert":
                    cars.get(commandArr[1]).set(0, cars.get(commandArr[1]).get(0) - Integer.parseInt(commandArr[2]));

                    if (cars.get(commandArr[1]).get(0) < 10000) {
                        cars.get(commandArr[1]).set(0, 10000);
                    } else {
                        System.out.println(commandArr[1] + " mileage decreased by " + commandArr[2] + " kilometers");
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : cars.entrySet()) {
            System.out.println(entry.getKey() + " -> Mileage: " + entry.getValue().get(0) + " kms, Fuel in the tank: " + entry.getValue().get(1) + " lt.");
        }
    }
}
