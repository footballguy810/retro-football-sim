package io.retrofootballfuture.sim;

import java.util.*;

public class WeeklyScheduler {
    private final int WEEKLY_BLOCK_LIMIT = 21; // 3 per day
    private int blocksUsed = 0;
    private Player player;
    private Random rand = new Random();
    private List<String> logs = new ArrayList<>();

    public WeeklyScheduler(Player player) {
        this.player = player;
    }

    public boolean scheduleActivity(String activity, String category, String intensity) {
        if (blocksUsed >= WEEKLY_BLOCK_LIMIT) {
            logs.add("[Overload] No more time blocks this week.");
            return false;
        }

        int blocks = switch (intensity) {
            case "Light" -> 1;
            case "Normal" -> 2;
            case "Intense" -> 3;
            default -> 2;
        };

        if (blocksUsed + blocks > WEEKLY_BLOCK_LIMIT) {
            logs.add("[Time Warning] Not enough blocks remaining for " + activity);
            return false;
        }

        int xpGain = calculateXPGain(category, intensity);
        applyXP(category, xpGain);
        applyConsequences(category, intensity);

        logs.add("Completed: " + activity + " | Type: " + category +
                " | Intensity: " + intensity + " | XP Gained: " + xpGain);

        blocksUsed += blocks;
        return true;
    }

    private int calculateXPGain(String category, String intensity) {
        int base = switch (intensity) {
            case "Light" -> 5;
            case "Normal" -> 10;
            case "Intense" -> 16;
            default -> 8;
        };

        // Modify by age curve
        if (category.equals("Skill") && player.getAge() > 22) {
            base -= 2;
        }

        // Add randomness
        return Math.max(1, base + rand.nextInt(4) - 2);
    }

    private void applyXP(String category, int xp) {
        player.addXP(category, xp);
    }

    private void applyConsequences(String category, String intensity) {
        int fatigue = switch (intensity) {
            case "Light" -> 2;
            case "Normal" -> 5;
            case "Intense" -> 8;
            default -> 4;
        };

        int moraleChange = 0;
        int injuryChance = 0;

        switch (category) {
            case "Skill", "Health" -> injuryChance = (intensity.equals("Intense")) ? 15 : 5;
            case "Life" -> moraleChange = +5;
            case "Mental" -> moraleChange = +3;
        }

        player.changeFatigue(fatigue);
        player.changeMorale(moraleChange);

        // Injury or burnout risk
        if (rand.nextInt(100) < injuryChance + player.getFatigue() / 2) {
            player.changeHealth(-5);
            logs.add("[Injury Risk] " + player.getName() + " suffered a minor setback.");
        }

        // Burnout flag
        if (player.getFatigue() > 85) {
            player.changeMorale(-10);
            logs.add("[Burnout] Warning: " + player.getName() + " may be overtraining.");
        }
    }

    public void printWeeklySummary() {
        System.out.println("----- Weekly Schedule Summary for " + player.getName() + " -----");
        for (String log : logs) {
            System.out.println(log);
        }
        System.out.println("Blocks Used: " + blocksUsed + "/" + WEEKLY_BLOCK_LIMIT);
        System.out.println("Skill: " + player.getXP("Skill") +
                " | Mental: " + player.getXP("Mental") +
                " | Life: " + player.getXP("Life") +
                " | Health: " + player.getXP("Health") +
                " | Reputation: " + player.getXP("Reputation"));
        System.out.println("Morale: " + player.getMorale() +
                " | Fatigue: " + player.getFatigue() +
                " | Health: " + player.getHealth());
        System.out.println("-----------------------------------------");
    }
}
