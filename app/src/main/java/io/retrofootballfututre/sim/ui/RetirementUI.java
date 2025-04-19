package ui;

import sim.Player;
import sim.RetirementPlan;

public class RetirementUI {

    public void showRetirementSummary(Player player, RetirementPlan plan) {
        System.out.println("🏁 Retirement Path for " + player.getName());
        System.out.println("Age: " + player.getAge());
        System.out.println("Career Stats: " + player.getCareerSummary());
        System.out.println("Retirement Plan: " + plan.getPostCareerPath());
        System.out.println("HOF Eligible: " + (plan.isHallOfFameCandidate() ? "Yes" : "No"));
    }

    public void confirmRetirement(Player player) {
        System.out.println("🏆 " + player.getName() + " has officially retired.");
        player.setRetired(true);
    }
}
