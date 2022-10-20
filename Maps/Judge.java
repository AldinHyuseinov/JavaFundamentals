package Maps;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> standings = new LinkedHashMap<>();

        while (!command.equals("no more time")) {
            String[] commandArr = command.split(" -> ");
            int points = Integer.parseInt(commandArr[2]);
            contests.putIfAbsent(commandArr[1], new LinkedHashMap<>());
            contests.get(commandArr[1]).put(commandArr[0], points);
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {
            for (Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
                standings.putIfAbsent(entry2.getKey(), 0);
                standings.put(entry2.getKey(), standings.get(entry2.getKey()) + entry2.getValue());
            }

        }
        AtomicInteger count = new AtomicInteger(1);

        for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " participants");
            entry.getValue().entrySet()
                    .stream().sorted((e, e2) -> {
                        if (e2.getValue() > e.getValue()) return 1;
                        else if (e2.getValue() < e.getValue()) return -1;
                        else return e.getKey().compareTo(e2.getKey());
                    })
                    .forEach(e -> {
                        System.out.printf("%d. %s <::> %d%n", count.get(), e.getKey(), e.getValue());
                        count.getAndIncrement();
                    });
            count.set(1);
        }
        System.out.println("Individual standings:");
        standings.entrySet()
                .stream().sorted((e, e2) -> {
                    if (e2.getValue() > e.getValue()) return 1;
                    else if (e2.getValue() < e.getValue()) return -1;
                    else return e.getKey().compareTo(e2.getKey());
                })
                .forEach(e -> {
                    System.out.printf("%d. %s -> %d%n", count.get(), e.getKey(), e.getValue());
                    count.getAndIncrement();
                });
    }
}
