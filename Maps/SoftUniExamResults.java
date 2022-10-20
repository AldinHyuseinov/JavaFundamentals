package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {
            String[] commandArr = command.split("-");

            if (commandArr[1].equals("banned")) {
                results.remove(commandArr[0]);
            } else {
                int points = Integer.parseInt(commandArr[2]);

                if (!results.containsKey(commandArr[0])) {
                    results.put(commandArr[0], points);
                } else {
                    results.put(commandArr[0], Math.max(points, results.get(commandArr[0])));
                }

                if (!submissions.containsKey(commandArr[1])) {
                    submissions.put(commandArr[1], 1);
                } else {
                    submissions.put(commandArr[1], submissions.get(commandArr[1]) + 1);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println("Results:");

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");

        for (Map.Entry<String, Integer> entry : submissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }
}
