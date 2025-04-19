package ui;

import sim.Coach;
import sim.Team;

public class CoachStrategyUI {
    public void displayStrategy(Coach coach) {
        System.out.println("📘 Coach Strategy Profile: " + coach.getName());
        System.out.println("Play Style: " + coach.getStyle());
        System.out.println("Unpredictability: " + coach.getUnpredictability());
        System.out.println("Preferred Formation: " + coach.getPreferredFormation());
    }

    public void adjustStrategy(Coach coach, String newStyle) {
        coach.setStyle(newStyle);
        System.out.println("✅ Strategy updated to: " + newStyle);
    }
}
