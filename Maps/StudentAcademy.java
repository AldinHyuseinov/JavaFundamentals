package Maps;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsAndGrades = new LinkedHashMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            studentsAndGrades.putIfAbsent(name, new ArrayList<>());

            if (studentsAndGrades.get(name).isEmpty()) {
                studentsAndGrades.get(name).add(grade);
                studentsAndGrades.get(name).add(1.00);
            } else {
                studentsAndGrades.get(name).set(0, studentsAndGrades.get(name).get(0) + grade);
                studentsAndGrades.get(name).set(1, studentsAndGrades.get(name).get(1) + 1);
            }
        }

        for (Map.Entry<String, List<Double>> entry : studentsAndGrades.entrySet()) {
            double avgGrade = entry.getValue().get(0) / entry.getValue().get(1);

            if (avgGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), avgGrade);
            }
        }
    }
}
