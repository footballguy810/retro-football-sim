package ui;

import sim.Player;
import sim.LifeEvent;

import java.util.List;

public class LifeEventUI {
    public void displayLifeTimeline(Player player, List<LifeEvent> events) {
        System.out.println("📆 Life Timeline for " + player.getName());
        for (LifeEvent event : events) {
            System.out.println("• Year " + event.getYear() + ": " + event.getDescription());
        }
    }

    public void celebrateEvent(LifeEvent event) {
        System.out.println("🎉 " + event.getDescription() + " was a milestone moment!");
    }
}
