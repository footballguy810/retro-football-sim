package ui;

import sim.Player;

public class DynamicReputationUI {
    public void displayReputationSummary(Player player) {
        System.out.println("🌟 Reputation Profile for " + player.getName());
        System.out.println("Team Player: " + player.getReputationScore("team"));
        System.out.println("Media: " + player.getReputationScore("media"));
        System.out.println("Fanbase: " + player.getReputationScore("fans"));
        System.out.println("Legacy: " + player.getReputationScore("legacy"));
    }

    public void updateReputation(Player player, String category, int delta) {
        player.adjustReputation(category, delta);
        System.out.println("🔄 " + category + " reputation updated by " + delta);
    }
}
