package Maps;

import java.util.*;

public class SupermarketDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String products = scanner.nextLine();
        Map<String, List<Double>> database = new LinkedHashMap<>();

        while (!products.equals("stocked")) {
            String[] productArr = products.split(" ");
            double price = Double.parseDouble(productArr[1]);
            double quantity = Double.parseDouble(productArr[2]);

            if (!database.containsKey(productArr[0])) {
                database.put(productArr[0], new ArrayList<>());
                database.get(productArr[0]).add(price);
                database.get(productArr[0]).add(quantity);
            } else {
                database.get(productArr[0]).set(1, database.get(productArr[0]).get(1) + quantity);

                if (!database.get(productArr[0]).get(0).equals(price)) {
                    database.get(productArr[0]).set(0, price);
                }
            }
            products = scanner.nextLine();
        }
        double totalSum = 0;

        for (Map.Entry<String, List<Double>> entry : database.entrySet()) {
            double sum = entry.getValue().get(0) * entry.getValue().get(1);
            System.out.printf("%s: $%.2f * %.0f = $%.2f%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), sum);
            totalSum += sum;
        }
        System.out.println("------------------------------");
        System.out.printf("Grand Total: $%.2f", totalSum);
    }
}