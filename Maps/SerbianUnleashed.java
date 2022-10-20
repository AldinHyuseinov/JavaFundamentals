package Maps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?<singer>\\w+ (\\w+ )?(\\w+ )?)@(?<venue>\\w+ (\\w+ )?(\\w+ )?)(?<ticketPrice>\\d+) (?<ticketCount>\\d+)$");
        Map<String, Map<String, Integer>> venueAndSingers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("ticketCount"));

                venueAndSingers.putIfAbsent(venue, new LinkedHashMap<>());

                if (!venueAndSingers.get(venue).containsKey(singer)) {
                    venueAndSingers.get(venue).put(singer, ticketPrice * ticketCount);
                } else {
                    venueAndSingers.get(venue).put(singer, venueAndSingers.get(venue).get(singer) + ticketPrice * ticketCount);
                }
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : venueAndSingers.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(singer -> System.out.println("#  " + singer.getKey() + "-> " + singer.getValue()));
        }
    }
}