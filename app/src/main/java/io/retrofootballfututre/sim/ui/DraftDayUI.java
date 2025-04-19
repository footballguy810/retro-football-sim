package ui;

import sim.Player;
import sim.DraftBoard;

import java.util.List;

public class DraftDayUI {
    public void displayDraftBoard(DraftBoard board) {
        System.out.println("🎯 Draft Day - Top Prospects:");
        List<Player> prospects = board.getTopProspects();
        for (int i = 0; i < prospects.size(); i++) {
            Player p = prospects.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getCollege() + " - Rating: " + p.getOverallRating());
        }
    }

    public void announceDraftPick(Player player, int pickNumber, String teamName) {
        System.out.println("With the #" + pickNumber + " pick, the " + teamName + " select: " + player.getName() + " from " + player.getCollege() + "!");
    }
}
