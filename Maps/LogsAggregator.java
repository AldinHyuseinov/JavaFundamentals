package Maps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int logLines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> usersAndLogs = new TreeMap<>();

        for (int i = 0; i < logLines; i++) {
            String[] logInfo = scanner.nextLine().split(" ");
            int duration = Integer.parseInt(logInfo[2]);
            usersAndLogs.putIfAbsent(logInfo[1], new TreeMap<>());

            if (!usersAndLogs.get(logInfo[1]).containsKey(logInfo[0])) {
                usersAndLogs.get(logInfo[1]).put(logInfo[0], duration);
            } else {
                usersAndLogs.get(logInfo[1]).put(logInfo[0], usersAndLogs.get(logInfo[1]).get(logInfo[0]) + duration);
            }
        }
        StringBuilder editPrint = new StringBuilder();

        for (Map.Entry<String, Map<String, Integer>> entry : usersAndLogs.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            editPrint.append(entry.getKey()).append(": ").append(sum).append(" ").append("[");

            for (Map.Entry<String, Integer> ipAndDuration : entry.getValue().entrySet()) {
                editPrint.append(ipAndDuration.getKey()).append(", ");
            }
            editPrint.deleteCharAt(editPrint.length() - 1);
            editPrint.deleteCharAt(editPrint.length() - 1);
            editPrint.append("]");
            System.out.println(editPrint);
            editPrint.delete(0, editPrint.length());
        }
    }
}
