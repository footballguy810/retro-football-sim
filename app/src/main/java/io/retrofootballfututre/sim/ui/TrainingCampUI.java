package ui;

import sim.Player;
import sim.Team;

import java.util.List;

public class TrainingCampUI {
    public void displayTrainingCamp(Team team) {
        System.out.println("🏕️ Training Camp - Team: " + team.getName());
        List<Player> players = team.getRoster();
        for (Player p : players) {
            System.out.println(p.getName() + " - Stamina: " + p.getStamina() + " | Morale: " + p.getMorale());
        }
    }

    public void assignFocusDrill(Player player, String drill) {
        System.out.println("💪 " + player.getName() + " assigned to: " + drill + " drill.");
        player.train(drill);
    }
}
