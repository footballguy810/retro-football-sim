package ui;

import sim.Player;
import sim.NILDeal;

import java.util.List;

public class NILDealsUI {

    public void listNILDeals(Player player, List<NILDeal> deals) {
        System.out.println("💼 NIL Opportunities for " + player.getName());
        for (NILDeal deal : deals) {
            System.out.println("- " + deal.getBrandName() + ": $" + deal.getAmount() + " | Exposure: " + deal.getBrandExposure());
        }
    }

    public void acceptDeal(Player player, NILDeal deal) {
        System.out.println("✅ " + player.getName() + " accepted deal with " + deal.getBrandName());
        player.addMorale(5);
        player.addBrandValue(deal.getBrandExposure());
    }
}
