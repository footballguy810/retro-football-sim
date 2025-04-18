import java.util.*;

public class HallOfFameManager {
    private static List<Player> inductedPlayers = new ArrayList<>();

    public static void evaluateForHOF(Player player) {
        if (player.getXP("Reputation") > 200 && player.getAccolades().size() > 5) {
            inductedPlayers.add(player);
            player.logEvent("Inducted into Hall of Fame!");
        }
    }

    public static void showHallOfFame() {
        System.out.println("--- Hall of Fame ---");
        for (Player p : inductedPlayers) {
            System.out.println(p.getName() + " | Age: " + p.getAge() + " | Accolades: " + p.getAccolades());
        }
    }
}
