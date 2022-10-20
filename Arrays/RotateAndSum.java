package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class RotateAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int rotations = Integer.parseInt(scanner.nextLine());
        List<Integer> prevList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();

        for (int i = 1; i <= rotations; i++) {
            Collections.rotate(intList, 1);

            if (!prevList.isEmpty()) {

                if (sumList.isEmpty()) {

                    for (int j = 0; j < intList.size(); j++) {
                        int sum = prevList.get(j) + intList.get(j);
                        sumList.add(sum);
                    }
                } else {

                    for (int j = 0; j < intList.size(); j++) {
                        sumList.set(j, sumList.get(j) + intList.get(j));
                    }
                }
            }
            prevList.clear();
            prevList.addAll(intList);
        }
        if (sumList.isEmpty()) {
            System.out.println(intList.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(sumList.toString().replaceAll("[\\[\\],]", ""));
        }
    }
}
