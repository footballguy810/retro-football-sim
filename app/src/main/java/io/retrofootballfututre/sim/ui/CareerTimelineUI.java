package ui;

import sim.Player;
import sim.TimelineEvent;

public class CareerTimelineUI {
    public void showTimeline(Player player) {
        System.out.println("📜 Career Timeline for " + player.getName() + ":");
        for (TimelineEvent event : player.getCareerTimeline()) {
            System.out.println(event.getFormatted());
        }
    }
}
