package Maps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> playersAndResults = new LinkedHashMap<>();
        Map<String, List<String>> playersDiscoveredCards = new HashMap<>();

        while (!command.equals("JOKER")) {
            String name = new Scanner(command).findInLine("\\w+:");
            String[] cards = command.replaceAll("\\w+: ", "").split(", ");
            playersAndResults.putIfAbsent(name, 0);
            playersDiscoveredCards.putIfAbsent(name, new ArrayList<>());
            int points = 0;

            for (String card : cards) {

                if (!playersDiscoveredCards.get(name).contains(card)) {
                    playersDiscoveredCards.get(name).add(card);
                } else {
                    continue;
                }

                int currentPoints = 0;
                String power;
                char type;

                if (card.length() == 3) {
                    power = String.valueOf(card.charAt(0)) + card.charAt(1);
                    type = card.charAt(2);
                } else {
                    power = String.valueOf(card.charAt(0));
                    type = card.charAt(1);
                }
                points += getPoints(currentPoints, power, type);
            }

            if (playersAndResults.get(name) == 0) {
                playersAndResults.put(name, points);
            } else {
                playersAndResults.put(name, playersAndResults.get(name) + points);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : playersAndResults.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private static int getPoints(int points, String power, char type) {

        switch (power) {
            case "J":
                points += 11;

                switch (type) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                }
                break;
            case "Q":
                points += 12;

                switch (type) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                }
                break;
            case "K":
                points += 13;

                switch (type) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                }
                break;
            case "A":
                points += 14;

                switch (type) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                }
                break;
            default:
                points += Integer.parseInt(power);

                switch (type) {
                    case 'S':
                        points *= 4;
                        break;
                    case 'H':
                        points *= 3;
                        break;
                    case 'D':
                        points *= 2;
                        break;
                }
                break;
        }
        return points;
    }
}
