package ui;

import sim.Play;
import sim.Team;

import java.util.List;
import java.util.Scanner;

public class PlayCallingUI {
    Scanner scanner = new Scanner(System.in);

    public void displayPlays(List<Play> plays, String phase) {
        System.out.println("📋 Available " + phase + " Plays:");
        for (int i = 0; i < plays.size(); i++) {
            Play p = plays.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - Type: " + p.getType() + " | Risk: " + p.getRiskLevel());
        }

        System.out.print("Choose a play to call: ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= plays.size()) {
            executePlay(plays.get(choice - 1));
        } else {
            System.out.println("❌ Invalid choice.");
        }
    }

    private void executePlay(Play play) {
        System.out.println("🧠 Executing play: " + play.getName());
        // Simulation logic should be called from MatchSimulator here
    }
}
