package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distancesToPokemon = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int removedElement;
        int sumOfElements = 0;

        while (!distancesToPokemon.isEmpty()) {
            int capturedPokemon = Integer.parseInt(scanner.nextLine());

            if (capturedPokemon < 0) {
                removedElement = distancesToPokemon.get(0);
                distancesToPokemon.remove(0);
                distancesToPokemon.add(0, distancesToPokemon.get(distancesToPokemon.size() - 1));
            } else if (capturedPokemon > distancesToPokemon.size() - 1) {
                removedElement = distancesToPokemon.get(distancesToPokemon.size() - 1);
                distancesToPokemon.remove(distancesToPokemon.size() - 1);
                distancesToPokemon.add(distancesToPokemon.size(), distancesToPokemon.get(0));
            } else {
                removedElement = distancesToPokemon.get(capturedPokemon);
                distancesToPokemon.remove(capturedPokemon);
            }
            sumOfElements += removedElement;

            for (int i = 0; i < distancesToPokemon.size(); i++) {

                if (distancesToPokemon.get(i) <= removedElement) {
                    distancesToPokemon.set(i, distancesToPokemon.get(i) + removedElement);
                } else if (distancesToPokemon.get(i) > removedElement) {
                    distancesToPokemon.set(i, distancesToPokemon.get(i) - removedElement);
                }
            }
        }
        System.out.println(sumOfElements);
    }
}
