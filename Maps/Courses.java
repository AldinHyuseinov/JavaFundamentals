package Maps;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" : ");
            courses.putIfAbsent(commandArr[0], new ArrayList<>());
            courses.get(commandArr[0]).add(commandArr[1]);
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println("-- " + entry.getValue().get(i));
            }
        }
    }
}
