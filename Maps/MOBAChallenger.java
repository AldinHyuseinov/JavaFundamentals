package MoreExercises;

import java.util.*;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> playerData = new TreeMap<>();

        while (!input.equals("Season end")) {

            if (input.contains("vs")) {
                String[] duelingPlayers = input.split(" vs ");

                if (playerData.containsKey(duelingPlayers[0]) && playerData.containsKey(duelingPlayers[1])) {

                    for (String key : playerData.get(duelingPlayers[0]).keySet()) {
                        boolean isBreak = false;

                        for (String key2 : playerData.get(duelingPlayers[1]).keySet()) {

                            if (playerData.get(duelingPlayers[0]).containsKey(key2) && playerData.get(duelingPlayers[1]).containsKey(key)) {

                                if (playerData.get(duelingPlayers[0]).get(key) > playerData.get(duelingPlayers[1]).get(key2)) {
                                    playerData.remove(duelingPlayers[1]);
                                } else if (playerData.get(duelingPlayers[0]).get(key) < playerData.get(duelingPlayers[1]).get(key2)) {
                                    playerData.remove(duelingPlayers[0]);
                                }
                                isBreak = true;
                                break;
                            }
                        }

                        if (isBreak) {
                            break;
                        }
                    }
                }
            } else {
                String[] players = input.split(" -> ");
                int skill = Integer.parseInt(players[2]);
                playerData.putIfAbsent(players[0], new TreeMap<>());
                playerData.get(players[0]).putIfAbsent(players[1], skill);

                if (playerData.get(players[0]).get(players[1]) < skill) {
                    playerData.get(players[0]).put(players[1], skill);
                }
            }
            input = scanner.nextLine();
        }
        Map<String, Integer> skills = new TreeMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : playerData.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            skills.put(entry.getKey(), sum);

        }
        skills.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
                    System.out.printf("%s: %d skill%n", e.getKey(), skills.get(e.getKey()));
                    playerData.get(e.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(el -> System.out.printf("- %s <::> %d%n", el.getKey(), el.getValue()));
                });
    }
}