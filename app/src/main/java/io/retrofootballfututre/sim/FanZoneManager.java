package io.retrofootballfuture.sim;

public class FanZoneManager {
    public void reactToGameResult(Team team, boolean win) {
        if (win) {
            System.out.println("Fans celebrate victory of " + team);
        } else {
            System.out.println("Fans are disappointed in " + team);
        }
    }
}