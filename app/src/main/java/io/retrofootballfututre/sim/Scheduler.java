package io.retrofootballfuture.sim;

import java.util.*;

public class Scheduler {
    private static final int MAX_TIME_SLOTS = 5;

    private Random rand = new Random();

    public void runWeeklySchedule(Player player, List<String> choices) {
        int slotsUsed = 0;

        for (String activity : choices) {
            if (slotsUsed >= MAX_TIME_SLOTS) break;
            slotsUsed++;

            switch (activity.toLowerCase()) {
                case "train":
                    player.earnXP("skill", 10);
                    player.earnXP("health", 5);
                    player.earnXP("mental", 3);
                    player.buyItem("Protein Bar");
                    player.addBadge("Hard Worker");
                    break;

                case "rest":
                    player.earnXP("health", 15);
                    player.earnXP("life", 5);
                    player.buyItem("Massage");
                    break;

                case "film":
                    player.earnXP("mental", 10);
                    player.earnXP("reputation", 2);
                    break;

                case "social":
                    player.earnXP("life", 10);
                    player.earnXP("reputation", 5);
                    player.buyItem("Fresh Fit");
                    player.addLifeEvent("Went to a party");
                    break;

                case "random":
                    int event = rand.nextInt(4);
                    switch (event) {
                        case 0: player.addLifeEvent("Had a tough conversation with coach"); break;
                        case 1: player.addLifeEvent("Fan altercation went viral"); player.earnXP("reputation", 15); break;
                        case 2: player.addLifeEvent("Met with agent for endorsement"); player.earnXP("life", 10); break;
                        case 3: player.addLifeEvent("Got a new car"); player.buyItem("Car"); break;
                    }
                    break;

                default:
                    System.out.println("Invalid activity: " + activity);
            }
        }

        player.weeklyUpdate();
    }
}
