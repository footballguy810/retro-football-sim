package ui;

import sim.Owner;
import sim.Team;

public class OwnerDashboardUI {
    public void displayOwnerInfo(Owner owner) {
        System.out.println("🏛️ Owner Dashboard - " + owner.getName());
        System.out.println("Team Owned: " + owner.getTeam().getName());
        System.out.println("Net Worth: $" + owner.getNetWorth() + "M");
        System.out.println("Reputation: " + owner.getReputation());
    }

    public void proposeRuleChange(String rule) {
        System.out.println("📜 Rule Change Proposed: " + rule);
        // Connect to league vote system
    }
}
