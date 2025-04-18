package io.retrofootballfuture.sim;

import java.util.*;

public class AssistantCoachAI {
    private String style;
    private double unpredictability;
    private int consistency;
    private int pressureLevel; // 0–100
    private Map<String, Integer> playerOvertrainMemory = new HashMap<>();
    private Map<String, Integer> relationshipScores = new HashMap<>();
    private Map<String, String> staffRecommendations = new HashMap<>();

    public AssistantCoachAI(String style) {
        this.style = style;
        this.unpredictability = Math.random();
        this.consistency = 50 + new Random().nextInt(51); // 50–100
        this.pressureLevel = 50;
    }

    public void adjustTraining(Team team) {
        for (Player p : team.getPlayers()) {
            int boost = getTrainingBoost(p);
            p.addXP("Skill", boost);
            p.addXP("Health", boost / 2);
            p.addXP("Mental", (int)(boost * 0.8));
            updateRelationship(p);

            int fatigueImpact = (int)(boost / 1.5);
            p.changeFatigue(fatigueImpact);

            // Overtraining memory
            if (fatigueImpact > 6) rememberTraining(p.getName());
            else forgetTraining(p.getName());

            if (playerOvertrainMemory.getOrDefault(p.getName(), 0) >= 3) {
                p.changeMorale(-5);
                logLifeEvent(p.getName() + " shows signs of burnout.");
            }

            // Morale vs Pressure
            if (p.getMorale() < 30 && pressureLevel > 70) {
                p.changeHealth(-2);
                logLifeEvent("Team pressure is hurting " + p.getName());
            }

            // Hidden style: some assistants recommend resting players
            if (unpredictability > 0.7 && p.getFatigue() > 80) {
                staffRecommendations.put(p.getName(), "Needs rest");
            }
        }

        generateWeeklyReport(team);
    }

    private void updateRelationship(Player p) {
        int score = relationshipScores.getOrDefault(p.getName(), 50);
        score += (p.getMorale() > 70) ? 2 : (p.getMorale() < 30 ? -2 : 0);
        relationshipScores.put(p.getName(), Math.min(100, Math.max(0, score)));
    }

    private void rememberTraining(String name) {
        playerOvertrainMemory.put(name, playerOvertrainMemory.getOrDefault(name, 0) + 1);
    }

    private void forgetTraining(String name) {
        int current = playerOvertrainMemory.getOrDefault(name, 0);
        if (current > 0) playerOvertrainMemory.put(name, current - 1);
    }

    private void generateWeeklyReport(Team team) {
        System.out.println("----- Assistant Coach Weekly Report -----");
        for (Player p : team.getPlayers()) {
            int rel = relationshipScores.getOrDefault(p.getName(), 50);
            System.out.println(p.getName() + " | Skill: " + p.getXP("Skill") +
                    " | Morale: " + p.getMorale() +
                    " | Fatigue: " + p.getFatigue() +
                    " | Relationship: " + rel +
                    (staffRecommendations.containsKey(p.getName()) ? 
                        " | Note: " + staffRecommendations.get(p.getName()) : ""));
        }
    }

    private void logLifeEvent(String message) {
        System.out.println("[Life Event] " + message);
    }

    private int getTrainingBoost(Player p) {
        int base = switch (style) {
            case "Aggressive" -> 8;
            case "Conservative" -> 4;
            case "Balanced" -> 6;
            default -> 5;
        };
        double chaos = unpredictability * 3;
        int boost = (int)(base + (Math.random() * chaos) - pressureLevel / 50.0);

        if (relationshipScores.getOrDefault(p.getName(), 50) > 80) {
            boost += 1; // chemistry bonus
        }

        return Math.max(1, boost);
    }

    public String giveStrategicAdvice(Team team, Team opponent) {
        return switch (style) {
            case "Aggressive" -> "We should start fast and punch them in the mouth.";
            case "Conservative" -> "Let's feel them out with safe plays.";
            default -> "Read their tempo, then adjust second half.";
        };
    }

    public void adjustPressure(int gameResult) {
        pressureLevel += (gameResult < 0) ? 10 : -5;
        pressureLevel = Math.min(100, Math.max(0, pressureLevel));
    }
}
