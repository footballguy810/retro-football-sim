package ui;

import sim.Prospect;

import java.util.List;

public class ScoutingReportUI {

    public void showScoutingReports(List<Prospect> prospects) {
        System.out.println("🔍 Scouting Report");
        for (Prospect p : prospects) {
            System.out.println(p.getName() + " | Pos: " + p.getPosition() +
                               " | Rating: " + p.getOverallRating() +
                               " | Traits: " + p.getScoutingTraits());
        }
    }
}
