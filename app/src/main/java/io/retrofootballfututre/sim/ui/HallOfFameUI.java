package ui;

import sim.Player;
import sim.HallOfFame;

import java.util.List;

public class HallOfFameUI {
    public void showHallOfFame() {
        List<Player> inductees = HallOfFame.getInductees();
        System.out.println("🏆 Hall of Fame Inductees:");
        for (Player p : inductees) {
            System.out.println(p.getName() + " - Career Stats: " + p.getCareerStats());
        }
    }
}
