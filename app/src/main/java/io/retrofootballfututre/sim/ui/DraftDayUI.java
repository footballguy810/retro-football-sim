package ui;

import sim.Player;
import sim.Team;
import sim.DraftPick;

import java.util.List;

public class DraftDayUI {

    public void displayDraftBoard(List<DraftPick> picks) {
        System.out.println("📋 Official Draft Board:");
        for (DraftPick pick : picks) {
            System.out.println("Pick #" + pick.getPickNumber() + ": " +
                               pick.getTeam().getName() + " selects " +
                               pick.getPlayer().getName() + " (" + pick.getPlayer().getCollegeName() + ")");
        }
    }

    public void showPlayerReaction(Player player, Team team) {
        System.out.println("🎉 " + player.getName() + " has been drafted by the " + team.getName() + "!");
        System.out.println("Contract Terms: " + player.getContractDetails());
    }
}
