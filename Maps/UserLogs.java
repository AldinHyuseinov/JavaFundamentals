package Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Map<String, Integer>> usersAndIps = new TreeMap<>();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            String[] ip = commandArr[0].split("=");
            String[] user = commandArr[2].split("=");
            usersAndIps.putIfAbsent(user[1], new LinkedHashMap<>());

            if (!usersAndIps.get(user[1]).containsKey(ip[1])) {
                usersAndIps.get(user[1]).put(ip[1], 1);
            } else {
                usersAndIps.get(user[1]).put(ip[1], usersAndIps.get(user[1]).get(ip[1]) + 1);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : usersAndIps.entrySet()) {
            System.out.println(entry.getKey() + ":");
            StringBuilder editPrint = new StringBuilder();

            for (Map.Entry<String, Integer> ipsAndCounts : entry.getValue().entrySet()) {
                editPrint.append(ipsAndCounts.getKey()).append(" => ").append(ipsAndCounts.getValue()).append(", ");
            }
            editPrint.deleteCharAt(editPrint.length() - 1);
            editPrint.deleteCharAt(editPrint.length() - 1);
            editPrint.append('.');
            System.out.println(editPrint);
        }
    }
}
