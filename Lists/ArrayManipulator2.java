package Lists;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("print")) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "add":
                    numbers.add(Integer.parseInt(commandArr[1]), Integer.parseInt(commandArr[2]));
                    break;
                case "addMany":
                    addMany(numbers, commandArr);
                    break;
                case "contains":
                    int num = numbers.indexOf(Integer.parseInt(commandArr[1]));
                    System.out.println(num);
                    break;
                case "remove":
                    numbers.remove(Integer.parseInt(commandArr[1]));
                    break;
                case "shift":
                    Collections.rotate(numbers, -Integer.parseInt(commandArr[1]));
                    break;
                case "sumPairs":
                    sumPairs(numbers);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(numbers);
    }

    private static void addMany(List<Integer> numbers, String[] commandArr) {
        int index = Integer.parseInt(commandArr[1]);
        numbers.add(index, Integer.parseInt(commandArr[2]));
        index++;

        for (int i = 3; i < commandArr.length; i++) {
            numbers.add(index, Integer.parseInt(commandArr[i]));
            index++;
        }
    }

    private static void sumPairs(List<Integer> numbers) {
        List<Integer> sumList = new ArrayList<>();
        int size = numbers.size() / 2;

        for (int i = 0; i < size; i++) {
            sumList.add(numbers.get(0) + numbers.get(1));
            numbers.remove(0);
            numbers.remove(0);
        }

        if (!numbers.isEmpty()) {
            sumList.add(numbers.get(0));
            numbers.clear();
        }
        numbers.addAll(sumList);
    }
}
