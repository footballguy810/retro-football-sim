package io.retrofootballfuture.sim;

public class ReputationModifier {
    public void applyModifier(Player p, String modifier) {
        switch (modifier) {
            case "Clutch":
                p.gainXP("Reputation", 10);
                break;
            case "Glory Hound":
                p.gainXP("Reputation", 5);
                break;
            case "Leader":
                p.gainXP("Reputation", 15);
                break;
            default:
                break;
        }
    }
}