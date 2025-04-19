package ui;

import sim.Player;
import sim.Team;

import java.util.Scanner;

public class NegotiationUI {
    private Scanner scanner;

    public NegotiationUI() {
        scanner = new Scanner(System.in);
    }

    public void negotiateContract(Player player, Team team) {
        System.out.println("=== Contract Negotiation ===");
        System.out.println("Team: " + team.getName());
        System.out.println("Negotiating with: " + player.getName());
        System.out.println("Current Offer: $" + player.getExpectedSalary() + "M/year");

        System.out.println("1. Accept");
        System.out.println("2. Counter Offer");
        System.out.println("3. Walk Away");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                player.setTeam(team);
                team.addPlayer(player);
                System.out.println(player.getName() + " signed with " + team.getName() + "!");
                break;
            case 2:
                System.out.print("Enter new offer: ");
                double offer = scanner.nextDouble();
                if (offer >= player.getExpectedSalary() * 0.9) {
                    player.setTeam(team);
                    team.addPlayer(player);
                    System.out.println("Negotiation successful! Signed for $" + offer + "M/year");
                } else {
                    System.out.println("Offer too low. Negotiation failed.");
                }
                break;
            default:
                System.out.println("Negotiation ended.");
                break;
        }
    }
}
