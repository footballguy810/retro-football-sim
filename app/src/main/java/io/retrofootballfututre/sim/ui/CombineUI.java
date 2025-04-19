package ui;

import sim.Player;
import sim.CombineResult;

import java.util.List;

public class CombineUI {
    public void displayCombineResults(List<CombineResult> results) {
        System.out.println("🏃 NFL Combine Results:");
        for (CombineResult r : results) {
            System.out.println(r.getPlayer().getName() + " - 40yd: " + r.getFortyTime() +
                    " | Bench: " + r.getBenchPress() + " reps | Wonderlic: " + r.getWonderlicScore());
        }
    }
}
