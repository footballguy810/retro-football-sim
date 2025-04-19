package ui;

import sim.Player;
import sim.Team;

import java.util.Scanner;

public class FanZoneUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayFanZone(Team team) {
        System.out.println("🏟️ Fan Zone - " + team.getName());
        System.out.println("Fanbase Rating: " + team.getFanRating());
        System.out.println("Celebrity Fans: " + String.join(", ", team.getCelebrityFans()));
        System.out.println("1. View MVP Fan Vote");
        System.out.println("2. Host Fan Event");
        System.out.println("3. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayFanVote(team);
                break;
            case 2:
                System.out.println("Fan event boosts morale. Feature coming soon.");
                break;
            default:
                break;
        }
    }

    private void displayFanVote(Team team) {
        System.out.println("Current Fan MVP Vote Leader: " + team.getFanMVP().getName());
    }
}
