package Methods;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "exchange":
                    int index = Integer.parseInt(commandArr[1]);

                    if (index > intList.size()) {
                        System.out.println("Invalid index");
                    } else {
                        exchange(intList, index);
                    }
                    break;
                case "max":
                    if (commandArr[1].equals("even")) {
                        maxEven(intList);
                    } else {
                        maxOdd(intList);
                    }
                    break;
                case "min":
                    if (commandArr[1].equals("even")) {
                        minEven(intList);
                    } else {
                        minOdd(intList);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(commandArr[1]);

                    if (count > intList.size()) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (commandArr[2].equals("even")) {
                        System.out.println(firstEven(intList, count));
                    } else {
                        System.out.println(firstOdd(intList, count));
                    }
                    break;
                case "last":
                    Collections.reverse(intList);
                    int lastCount = Integer.parseInt(commandArr[1]);

                    if (lastCount > intList.size()) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (commandArr[2].equals("even")) {
                        System.out.println(lastEven(intList, lastCount));
                    } else {
                        System.out.println(lastOdd(intList, lastCount));
                    }
                    Collections.reverse(intList);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(intList);
    }

    public static void exchange(List<Integer> integerList, int index) {
        Integer[] arr = integerList.toArray(Integer[]::new);

        for (int i = 1; i <= index + 1; i++) {
            int first = arr[0];

            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = first;
        }
        integerList.clear();
        Collections.addAll(integerList, arr);
    }

    public static void maxEven(List<Integer> integerList) {
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) % 2 == 0) {

                if (integerList.get(i) >= max) {
                    max = integerList.get(i);
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void maxOdd(List<Integer> integerList) {
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) % 2 != 0) {

                if (integerList.get(i) >= max) {
                    max = integerList.get(i);
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void minEven(List<Integer> integerList) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) % 2 == 0) {

                if (integerList.get(i) <= min) {
                    min = integerList.get(i);
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static void minOdd(List<Integer> integerList) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < integerList.size(); i++) {

            if (integerList.get(i) % 2 != 0) {

                if (integerList.get(i) <= min) {
                    min = integerList.get(i);
                    index = i;
                }
            }
        }
        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    public static List<Integer> firstEven(List<Integer> integerList, int count) {
        List<Integer> firstEvenList = new ArrayList<>();

        for (Integer integer : integerList) {

            if (integer % 2 == 0) {
                firstEvenList.add(integer);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        return firstEvenList;
    }

    public static List<Integer> firstOdd(List<Integer> integerList, int count) {
        List<Integer> firstOddList = new ArrayList<>();

        for (Integer integer : integerList) {

            if (integer % 2 != 0) {
                firstOddList.add(integer);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        return firstOddList;
    }

    public static List<Integer> lastEven(List<Integer> integerList, int count) {
        List<Integer> lastEvenList = new ArrayList<>();

        for (Integer integer : integerList) {

            if (integer % 2 == 0) {
                lastEvenList.add(integer);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        Collections.reverse(lastEvenList);
        return lastEvenList;
    }

    public static List<Integer> lastOdd(List<Integer> integerList, int count) {
        List<Integer> lastOddList = new ArrayList<>();

        for (Integer integer : integerList) {

            if (integer % 2 != 0) {
                lastOddList.add(integer);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        Collections.reverse(lastOddList);
        return lastOddList;
    }
}