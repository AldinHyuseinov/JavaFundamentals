package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImmuneSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = Integer.parseInt(scanner.nextLine());
        int maxHp = health;
        String virusName = scanner.nextLine();
        List<String> encounteredViruses = new ArrayList<>();

        while (!virusName.equals("end")) {
            int timeToDefeatVirus = 0;

            for (int i = 0; i < virusName.length(); i++) {
                timeToDefeatVirus += virusName.charAt(i);
            }
            timeToDefeatVirus /= 3;
            int virusStrength = timeToDefeatVirus;
            timeToDefeatVirus *= virusName.length();

            if (encounteredViruses.contains(virusName)) {
                timeToDefeatVirus /= 3;
            }
            health -= timeToDefeatVirus;
            encounteredViruses.add(virusName);
            System.out.printf("Virus %s: %d => %d seconds%n", virusName, virusStrength, timeToDefeatVirus);

            if (health > 0) {
                double minutes = timeToDefeatVirus / 60.00;
                int sec = (int) minutes;
                System.out.printf("%s defeated in %dm %.0fs.%n", virusName, sec, (minutes - sec) * 60);
                System.out.println("Remaining health: " + health);
                health += health * 0.20;

                if (health > maxHp) {
                    health = maxHp;
                }
            } else {
                System.out.println("Immune System Defeated.");
                return;
            }
            virusName = scanner.nextLine();
        }
        System.out.println("Final Health: " + health);
    }
}
