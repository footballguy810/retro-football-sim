package io.retrofootballfuture.sim;

import java.util.*;

public class RecruitingAI {
    private String strategy;
    private int memorySuccess = 0;
    private int memoryFailures = 0;
    private Random rand = new Random();

    public RecruitingAI(String strategy) {
        this.strategy = strategy;
    }

    public Player scoutPlayer(String level) {
        String[] names = {"Jayden", "Zion", "Malik", "Trey", "Kai"};
        String name = names[rand.nextInt(names.length)];
        int age = level.equals("HighSchool") ? 16 + rand.nextInt(3) : 18 + rand.nextInt(3);
        Player p = new Player(name, age);
        p.addXP("Skill", 50 + rand.nextInt(40));
        p.setEgo(rand.nextInt(100));
        p.setBrand(rand.nextInt(50));
        return p;
    }

    public String generateScoutReport(Player p) {
        return "SCOUT REPORT:\n" +
                "- Name: " + p.getName() +
                "\n- Age: " + p.getAge() +
                "\n- Skill XP: " + p.getXP("Skill") +
                "\n- Ego: " + p.getEgo() +
                "\n- Brand: " + p.getBrand() +
                "\n- Projection: " + getProjection(p);
    }

    public boolean evaluateFit(Player p, Team team) {
        return switch (strategy) {
            case "StarHunter" -> p.getXP("Skill") >= 85;
            case "TeamFit" -> p.getXP("Skill") >= 65 && p.getEgo() <= 50;
            case "HighCeiling" -> p.getXP("Skill") >= 50 && p.getAge() <= 19;
            default -> p.getXP("Skill") >= 60;
        };
    }

    public void makeOffer(Player p, Team team) {
        boolean fit = evaluateFit(p, team);
        boolean accepts = negotiateOffer(p, team);

        if (fit && accepts) {
            team.addPlayer(p);
            memorySuccess++;
            logRecruit(p.getName() + " signed with " + team.getName());
        } else {
            memoryFailures++;
            logRecruit(p.getName() + " rejected offer from " + team.getName());
        }
    }

    private boolean negotiateOffer(Player p, Team team) {
        int baseChance = 60;
        baseChance += (team.getMarketRating() / 2);
        baseChance -= (p.getEgo() / 3);

        if (p.getBrand() > 70) baseChance -= 10;

        // NIL deal bonus
        if (team.supportsNIL()) {
            int nilBonus = 5 + rand.nextInt(20);
            baseChance += nilBonus;
            logRecruit("NIL deal offered to " + p.getName() + " [+ " + nilBonus + "%]");
        }

        // Agents may reduce chance unless relationship is good
        if (rand.nextBoolean()) {
            baseChance -= 5;
            logRecruit(p.getName() + "'s agent delayed talks.");
        }

        return rand.nextInt(100) < baseChance;
    }

    private String getProjection(Player p) {
        if (p.getXP("Skill") > 90) return "Future Star";
        if (p.getXP("Skill") > 70) return "Starter Potential";
        return "Raw Talent";
    }

    public void signingDayReport() {
        System.out.println("SIGNING DAY SUMMARY:");
        System.out.println("Success: " + memorySuccess + ", Misses: " + memoryFailures);
    }

    private void logRecruit(String message) {
        System.out.println("[Recruiting Log] " + message);
    }
}
