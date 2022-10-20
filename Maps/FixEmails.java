package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            namesAndEmails.put(name, email);
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : namesAndEmails.entrySet()) {

            if (!entry.getValue().endsWith(".us") && !entry.getValue().endsWith(".uk")) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            } else {
                namesAndEmails.remove(entry.getKey());
            }
        }
    }
}