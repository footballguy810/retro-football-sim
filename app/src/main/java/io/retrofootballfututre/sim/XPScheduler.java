package io.retrofootballfuture.sim;

public class XPScheduler {
    public void assignActivity(Player player, String type, int intensity) {
        int xp = intensity * 5;
        player.gainXP(type, xp);
    }
}