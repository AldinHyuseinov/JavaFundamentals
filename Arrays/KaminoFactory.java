package Arrays;

import java.util.*;

public class KaminoFactory {

    static class Factory {
        int[] seq;

        public Factory(int[] seq) {
            this.seq = seq;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        List<Factory> storage = new ArrayList<>();

        while (!command.equals("Clone them!")) {
            Factory clones = new Factory(Arrays.stream(command.split("!+")).mapToInt(Integer::parseInt).toArray());
            storage.add(clones);

            command = scanner.nextLine();
        }
        Map<Integer, List<Integer>> seqMap = new LinkedHashMap<>();

        for (int i = 0; i < storage.size(); i++) {
            seqMap.put(i, new ArrayList<>());
            int count = 0;
            int winSum = 0;

            for (int j = 0; j < storage.get(i).seq.length; j++) {
                int kCycles = 0;

                for (int k = j + 1; k < storage.get(i).seq.length; k++) {

                    if (storage.get(i).seq[j] == storage.get(i).seq[k] && storage.get(i).seq[j] == 1) {
                        seqMap.get(i).add(storage.get(i).seq[j]);
                        winSum++;

                        if (kCycles <= 0) {
                            seqMap.get(i).add(storage.get(i).seq[j]);
                            winSum++;
                        } else {
                            j++;
                        }
                        count++;

                        if (count == 1) {
                            seqMap.get(i).add(0, j);
                        }
                        seqMap.get(i).add(1, winSum);
                        kCycles++;
                    } else {
                        break;
                    }
                }
            }
        }
        int size = seqMap.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (seqMap.size() == 1) {
                    break;
                }

                if (seqMap.get(i).size() > seqMap.get(j).size()) {
                    seqMap.remove(j);
                } else if (seqMap.get(i).size() == seqMap.get(j).size()) {

                    if (seqMap.get(i).get(0) < seqMap.get(j).get(0)) {
                        seqMap.remove(j);
                    } else if (seqMap.get(i).get(0) > seqMap.get(j).get(0)) {
                        seqMap.remove(i);
                    } else if (seqMap.get(i).get(0).equals(seqMap.get(j).get(0))) {
                        int sum = Arrays.stream(storage.get(i).seq).sum();
                        int sum2 = Arrays.stream(storage.get(j).seq).sum();

                        if (sum > sum2) {
                            seqMap.remove(j);
                            seqMap.get(i).set(1, sum);
                        } else {
                            seqMap.remove(i);
                            seqMap.get(j).set(1, sum2);
                        }
                    }
                }
            }
        }

        for (Integer k : seqMap.keySet()) {
            System.out.printf("Best DNA sample %d with sum: %d.%n", k + 1, seqMap.get(k).get(1));

            for (int s : storage.get(k).seq) {
                System.out.print(s + " ");
            }
        }
    }
}
