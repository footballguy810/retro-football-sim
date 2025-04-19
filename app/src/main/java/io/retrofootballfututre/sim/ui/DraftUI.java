package ui;

import sim.Player;
import sim.Team;

import java.util.List;
import java.util.Scanner;

public class DraftUI {
    private Scanner scanner;

    public DraftUI() {
        scanner = new Scanner(System.in);
    }

    public void runDraft(List<Player> draftPool, List<Team> teams) {
        System.out.println("=== Draft Day ===");

        for (Team team : teams) {
            System.out.println("Team: " + team.getName());
            System.out.println("Available Players:");
            for (int i = 0; i < draftPool.size(); i++) {
                System.out.println((i + 1) + ". " + draftPool.get(i).getFullSummary());
            }

            System.out.print("Select a player for " + team.getName() + ": ");
            int selection = scanner.nextInt() - 1;
            if (selection >= 0 && selection < draftPool.size()) {
                Player drafted = draftPool.remove(selection);
                team.addPlayer(drafted);
                drafted.setTeam(team);
                System.out.println(team.getName() + " drafts " + drafted.getName() + "!");
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }
}
