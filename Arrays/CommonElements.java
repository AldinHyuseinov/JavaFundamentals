package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> firstList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> secList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        for (String first : secList) {
            for (String sec : firstList) {

                if (first.equals(sec)) {
                    System.out.print(sec + " ");
                }
            }
        }
    }
}
