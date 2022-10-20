package Maps;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> companyAndEmployees = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" -> ");
            companyAndEmployees.putIfAbsent(commandArr[0], new ArrayList<>());

            if (!companyAndEmployees.get(commandArr[0]).contains(commandArr[1])) {
                companyAndEmployees.get(commandArr[0]).add(commandArr[1]);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companyAndEmployees.entrySet()) {
            System.out.println(entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- " + entry.getValue().get(i));
            }
        }
    }
}