package ui;

import sim.MediaReport;
import sim.Player;

import java.util.List;

public class MediaCenterUI {
    public void displayMedia(Player player) {
        System.out.println("📰 Media Center for " + player.getName());
        List<MediaReport> reports = player.getMediaReports();
        for (MediaReport report : reports) {
            System.out.println("[" + report.getDate() + "] " + report.getTitle() + " - " + report.getSummary());
        }
    }
}
