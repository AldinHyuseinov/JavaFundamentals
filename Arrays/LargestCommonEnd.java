package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestCommonEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> words2 = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int largestLeft;
        int largestRight;

        if (words.size() < words2.size()) {
            largestLeft = scanLeftToRight(words, words2);
            largestRight = scanRightToLeft(words, words2);
        } else {
            largestLeft = scanLeftToRight(words2, words);
            largestRight = scanRightToLeft(words2, words);
        }
        int largestCommonEnd = Math.max(largestLeft, largestRight);
        System.out.println(largestCommonEnd);
    }

    public static int scanLeftToRight(List<String> shortList, List<String> longerList) {
        int leftSum = 0;

        for (int i = 0; i < shortList.size(); i++) {

            if (shortList.get(i).equals(longerList.get(i))) {
                leftSum++;
            } else {
                break;
            }
        }
        return leftSum;
    }

    public static int scanRightToLeft(List<String> shortList, List<String> longerList) {
        Collections.reverse(shortList);
        Collections.reverse(longerList);
        int rightSum = 0;

        for (int i = 0; i < shortList.size(); i++) {

            if (shortList.get(i).equals(longerList.get(i))) {
                rightSum++;
            } else {
                break;
            }
        }
        return rightSum;
    }
}
