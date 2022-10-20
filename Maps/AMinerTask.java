package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!command.equals("stop")) {
            int amount = Integer.parseInt(scanner.nextLine());

            if (!resources.containsKey(command)) {
                resources.put(command, amount);
            } else {
                resources.put(command, resources.get(command) + amount);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
