package ui;

import sim.Team;
import sim.Player;

import java.util.List;
import java.util.Scanner;

public class TeamManagementUI {
    private Scanner scanner;

    public TeamManagementUI() {
        scanner = new Scanner(System.in);
    }

    public void showTeamManagement(Team team) {
        System.out.println("=== Team Management: " + team.getName() + " ===");
        System.out.println("1. View Roster");
        System.out.println("2. Set Depth Chart");
        System.out.println("3. Manage Playbook");
        System.out.println("4. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                viewRoster(team.getPlayers());
                break;
            case 2:
                System.out.println("Depth chart management coming soon.");
                break;
            case 3:
                System.out.println("Playbook editing coming soon.");
                break;
            default:
                break;
        }
    }

    private void viewRoster(List<Player> roster) {
        System.out.println("--- Roster ---");
        for (Player player : roster) {
            System.out.println(player.getFullSummary());
        }
    }
}
