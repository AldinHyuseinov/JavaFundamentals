package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> seq = new ArrayList<>();
        List<Integer> winSeq = new ArrayList<>();
        int size = Integer.MIN_VALUE;

        for (int i = 0; i < intList.size(); i++) {
            int jCycles = 0;

            for (int j = i + 1; j < intList.size(); j++) {

                if (intList.get(i).equals(intList.get(j))) {

                    seq.add(intList.get(i));

                    if (jCycles <= 0) {
                        seq.add(intList.get(j));
                    } else {
                        i++;
                    }
                    jCycles++;
                } else {
                    break;
                }
            }

            if (seq.size() > size && !seq.isEmpty()) {
                size = seq.size();
                winSeq.clear();
                winSeq.addAll(seq);
            }
            seq.clear();
        }
        System.out.println(winSeq.toString().replaceAll("[\\[\\],]", ""));
    }
}
