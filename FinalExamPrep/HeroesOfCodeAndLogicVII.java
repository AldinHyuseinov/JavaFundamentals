package FinalExamPrep;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesAndStats = new LinkedHashMap<>();

        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroAndStats = scanner.nextLine().split(" ");
            int hp = Integer.parseInt(heroAndStats[1]);
            int mana = Integer.parseInt(heroAndStats[2]);

            heroesAndStats.putIfAbsent(heroAndStats[0], new ArrayList<>());
            heroesAndStats.get(heroAndStats[0]).add(hp);
            heroesAndStats.get(heroAndStats[0]).add(mana);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] actions = command.split(" - ");

            switch (actions[0]) {
                case "CastSpell":
                    int neededMp = Integer.parseInt(actions[2]);

                    if (heroesAndStats.get(actions[1]).get(1) >= neededMp) {
                        heroesAndStats.get(actions[1]).set(1, heroesAndStats.get(actions[1]).get(1) - neededMp);
                        System.out.println(actions[1] + " has successfully cast " + actions[3] + " and now has " + heroesAndStats.get(actions[1]).get(1) + " MP!");
                    } else {
                        System.out.println(actions[1] + " does not have enough MP to cast " + actions[3] + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(actions[2]);
                    heroesAndStats.get(actions[1]).set(0, heroesAndStats.get(actions[1]).get(0) - damage);

                    if (heroesAndStats.get(actions[1]).get(0) > 0) {
                        System.out.println(actions[1] + " was hit for " + damage + " HP by " + actions[3] + " and now has " + heroesAndStats.get(actions[1]).get(0) + " HP left!");
                    } else {
                        heroesAndStats.remove(actions[1]);
                        System.out.println(actions[1] + " has been killed by " + actions[3] + "!");
                    }
                    break;
                case "Recharge":
                    int currentMp = heroesAndStats.get(actions[1]).get(1);
                    int amountOfMp = Integer.parseInt(actions[2]);
                    heroesAndStats.get(actions[1]).set(1, heroesAndStats.get(actions[1]).get(1) + amountOfMp);

                    if (heroesAndStats.get(actions[1]).get(1) > 200) {
                        heroesAndStats.get(actions[1]).set(1, 200);
                        System.out.println(actions[1] + " recharged for " + (200 - currentMp) + " MP!");
                    } else {
                        System.out.println(actions[1] + " recharged for " + amountOfMp + " MP!");
                    }
                    break;
                case "Heal":
                    int currentHp = heroesAndStats.get(actions[1]).get(0);
                    int amountOfHp = Integer.parseInt(actions[2]);
                    heroesAndStats.get(actions[1]).set(0, heroesAndStats.get(actions[1]).get(0) + amountOfHp);

                    if (heroesAndStats.get(actions[1]).get(0) > 100) {
                        heroesAndStats.get(actions[1]).set(0, 100);
                        System.out.println(actions[1] + " healed for " + (100 - currentHp) + " HP!");
                    } else {
                        System.out.println(actions[1] + " healed for " + amountOfHp + " HP!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : heroesAndStats.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("  HP: " + entry.getValue().get(0));
            System.out.println("  MP: " + entry.getValue().get(1));
        }
    }
}
