package ui;

import sim.Player;
import sim.Badge;

import java.util.List;

public class BadgeViewerUI {
    public void displayBadges(Player player) {
        System.out.println("🎖️ Badge Viewer - " + player.getName());
        List<Badge> badges = player.getBadges();
        for (Badge b : badges) {
            System.out.println(b.getName() + " - " + b.getDescription() + " (Tier: " + b.getTier() + ")");
        }
    }
}
