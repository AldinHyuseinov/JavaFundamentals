package Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arraysOfNumbers = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
        Collections.reverse(arraysOfNumbers);
        String[] arr = new String[arraysOfNumbers.size()];

        for (int i = 0; i < arraysOfNumbers.size(); i++) {

            if (arraysOfNumbers.get(i).charAt(0) == 32) {
                arr[i] = arraysOfNumbers.get(i).replaceFirst(" ", "");
            } else {
                arr[i] = arraysOfNumbers.get(i);
            }

            if (arraysOfNumbers.get(i).charAt(arraysOfNumbers.get(i).length() - 1) == 32) {
                arr[i] = arraysOfNumbers.get(i).substring(0, arraysOfNumbers.get(i).length() - 1);
            }
        }
        System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
    }
}
