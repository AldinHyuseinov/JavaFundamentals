package Maps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String report = scanner.nextLine();
        Map<String, Map<String, Long>> population = new LinkedHashMap<>();

        while (!report.equals("report")) {
            String[] stats = report.split("\\|");
            population.putIfAbsent(stats[1], new LinkedHashMap<>());
            population.get(stats[1]).put(stats[0], Long.parseLong(stats[2]));
            report = scanner.nextLine();
        }
        Map<String, Long> totalPop = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Long>> entry : population.entrySet()) {
            long total = 0;

            for (Map.Entry<String, Long> totalPopCounter : entry.getValue().entrySet()) {
                total += totalPopCounter.getValue();
            }
            totalPop.put(entry.getKey(), total);
        }

        totalPop.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
                    System.out.println(e.getKey() + " (total population: " + e.getValue() + ")");

                    for (Map.Entry<String, Map<String, Long>> countries : population.entrySet()) {

                        if (e.getKey().equals(countries.getKey())) {
                            countries.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                    .forEach(city -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));
                            break;
                        }
                    }
                });
    }
}