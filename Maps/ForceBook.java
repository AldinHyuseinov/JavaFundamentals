package Maps;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> sideAndUsers = new LinkedHashMap<>();
        String[] commandArr;

        while (!command.equals("Lumpawaroo")) {

            if (command.contains("|")) {
                commandArr = command.split("\\s+\\|\\s+");
                String side = commandArr[0];
                String user = commandArr[1];
                checkCreateAndAdd(sideAndUsers, side, user);
            } else {
                commandArr = command.split("\\s+->\\s+");
                String side = commandArr[1];
                String user = commandArr[0];

                for (Map.Entry<String, List<String>> entry : sideAndUsers.entrySet()) {

                    if (entry.getValue().contains(user)) {
                        entry.getValue().remove(user);
                    }

                    if (entry.getValue().isEmpty()) {
                        sideAndUsers.remove(entry.getKey());
                    }
                }
                checkCreateAndAdd(sideAndUsers, side, user);
                System.out.println(user + " joins the " + side + " side!");
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : sideAndUsers.entrySet()) {
            System.out.println("Side: " + entry.getKey() + ", Members: " + entry.getValue().size());

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("! " + entry.getValue().get(i));
            }
        }
    }

    private static void checkCreateAndAdd(Map<String, List<String>> sideAndUsers, String side, String user) {
        sideAndUsers.putIfAbsent(side, new ArrayList<>());

        if (!sideAndUsers.get(side).contains(user)) {
            sideAndUsers.get(side).add(user);
        }
    }
}
