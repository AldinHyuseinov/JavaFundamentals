package Maps;

import java.util.*;

public class DragonArmy {

    static class DragonStats {
        int damage;
        int health;
        int armor;

        public DragonStats() {
        }

        public DragonStats(int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        int healthNull(String health) {

            if (health.equals("null")) {
                return 250;
            }
            return Integer.parseInt(health);
        }

        int damageNull(String damage) {

            if (damage.equals("null")) {
                return 45;
            }
            return Integer.parseInt(damage);
        }

        int armorNull(String armor) {

            if (armor.equals("null")) {
                return 10;
            }
            return Integer.parseInt(armor);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<DragonStats>>> dragons = new LinkedHashMap<>();
        DragonStats stats = new DragonStats();

        for (int i = 0; i < numberOfDragons; i++) {
            String[] input = scanner.nextLine().split(" ");
            stats = new DragonStats(stats.damageNull(input[2]), stats.healthNull(input[3]), stats.armorNull(input[4]));
            dragons.putIfAbsent(input[0], new TreeMap<>());
            dragons.get(input[0]).putIfAbsent(input[1], new ArrayList<>());

            if (!dragons.get(input[0]).get(input[1]).isEmpty()) {
                dragons.get(input[0]).get(input[1]).remove(0);
            }
            dragons.get(input[0]).get(input[1]).add(stats);
        }

        for (Map.Entry<String, Map<String, List<DragonStats>>> entry : dragons.entrySet()) {
            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;

            for (Map.Entry<String, List<DragonStats>> avgStats : entry.getValue().entrySet()) {
                avgDamage += avgStats.getValue().get(0).damage;
                avgHealth += avgStats.getValue().get(0).health;
                avgArmor += avgStats.getValue().get(0).armor;
            }
            avgDamage /= entry.getValue().values().size();
            avgHealth /= entry.getValue().values().size();
            avgArmor /= entry.getValue().values().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDamage, avgHealth, avgArmor);

            for (Map.Entry<String, List<DragonStats>> printDragons : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", printDragons.getKey(),
                        printDragons.getValue().get(0).damage, printDragons.getValue().get(0).health, printDragons.getValue().get(0).armor);
            }
        }
    }
}
