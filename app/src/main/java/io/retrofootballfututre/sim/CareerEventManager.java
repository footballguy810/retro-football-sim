package io.retrofootballfuture.sim;

public class CareerEventManager {
    public void checkMilestone(Player p) {
        if (p.getSkill() >= 90 && p.getFame() > 50) {
            System.out.println(p + " is entering Hall of Fame consideration.");
        }
    }
}