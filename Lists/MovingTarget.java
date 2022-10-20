package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequenceOfTargets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();

        while (!commands.equals("End")) {
            String[] commandsArr = commands.split(" ");
            int index = Integer.parseInt(commandsArr[1]);
            int value = Integer.parseInt(commandsArr[2]);

            switch (commandsArr[0]) {
                case "Shoot":

                    if (index < 0 || index > sequenceOfTargets.size() - 1) {
                        break;
                    } else {
                        sequenceOfTargets.set(index, sequenceOfTargets.get(index) - value);
                    }

                    if (sequenceOfTargets.get(index) <= 0) {
                        sequenceOfTargets.remove(index);
                    }
                    break;
                case "Add":

                    if (index < 0 || index > sequenceOfTargets.size() - 1) {
                        System.out.println("Invalid placement!");
                        break;
                    } else {
                        sequenceOfTargets.add(index, value);
                    }
                    break;
                case "Strike":
                    int cycleCount = 0;

                    if (index < 0 || index > sequenceOfTargets.size() - 1) {
                        System.out.println("Strike missed!");
                        break;
                    }
                    int cycleValue = value;
                    int strikeNum = sequenceOfTargets.get(index);

                    for (int i = index - 1; i >= 0; i--) {
                        sequenceOfTargets.remove(i);
                        cycleValue--;
                        cycleCount++;

                        if (cycleValue <= 0) {
                            break;
                        }
                    }
                    if (cycleCount == 0) {
                        System.out.println("Strike missed!");
                        break;
                    }
                    cycleValue = value;
                    int strikeIndex = sequenceOfTargets.indexOf(strikeNum);

                    for (int i = strikeIndex + 1; i < sequenceOfTargets.size(); i++) {
                        sequenceOfTargets.remove(i);
                        cycleValue--;
                        i--;
                        cycleCount++;

                        if (cycleValue <= 0) {
                            break;
                        }
                    }
                    if (cycleCount == 0) {
                        System.out.println("Strike missed!");
                        break;
                    }
                    strikeIndex = sequenceOfTargets.indexOf(strikeNum);
                    sequenceOfTargets.remove(strikeIndex);
                    break;
            }
            commands = scanner.nextLine();
        }
        StringBuilder form = new StringBuilder();

        for (int i : sequenceOfTargets) {
            form.append(String.format("%d|", i));
        }
        form.deleteCharAt(form.length() - 1);
        System.out.println(form);
    }
}
