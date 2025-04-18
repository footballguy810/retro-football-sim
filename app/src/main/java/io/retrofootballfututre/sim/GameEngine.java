package io.retrofootballfuture.sim;

import java.util.*;

public class GameEngine {
    private Team teamA;
    private Team teamB;
    private Scheduler scheduler;
    private AssistantCoachAI assistantCoachAI;
    private int currentWeek;

    public GameEngine() {
        scheduler = new Scheduler();
        assistantCoachAI = new AssistantCoachAI(); // Placeholder logic
        currentWeek = 1;

        // Initialize Teams
        teamA = new Team("Sharks");
        teamB = new Team("Wolves");

        // Create Players
        Player p1 = new Player("Alex", 20);
        Player p2 = new Player("Blake", 22);

        // Add Players
        teamA.addPlayer(p1);
        teamB.addPlayer(p2);

        // Assign Coaches
        teamA.setCoach(new Coach("Coach Z", "Aggressive", 85));
        teamB.setCoach(new Coach("Coach Y", "Balanced", 80));
    }

    public String simulateWeek() {
        StringBuilder log = new StringBuilder();
        log.append("=== WEEK ").append(currentWeek).append(" SCHEDULE ===\n");

        for (Player player : teamA.getPlayers()) {
            log.append("\n> ").append(player.getName()).append(" (").append(teamA.getName()).append(")\n");

            List<String> activities = generateActivitiesForPlayer(player);
            scheduler.runWeeklySchedule(player, activities);

            assistantCoachAI.adjustTrainingFocus(player, teamA.getCoach());

            log.append("Life Events: ").append(player.getLifeEvents()).append("\n");
            log.append("Items: ").append(player.getInventory()).append("\n");
            log.append("XP: ").append(player.getXpMap()).append("\n");
            log.append("Badges: ").append(player.getBadges()).append("\n");
            log.append("Reputation: ").append(player.getEgoRating()).append("\n");
            log.append("Morale: ").append(player.getMorale()).append(", Fatigue: ").append(player.getFatigue()).append("\n");
        }

        currentWeek++;
        return log.toString();
    }

    public String simulateGame() {
        int skillA = teamA.getTeamSkill();
        int skillB = teamB.getTeamSkill();

        // Coach and staff influence
        skillA += teamA.getCoach().getStrategyRating() / 10;
        skillB += teamB.getCoach().getStrategyRating() / 10;

        // Fan boost
        skillA += teamA.getFanSystem().getFanEngagementLevel() / 5;
        skillB += teamB.getFanSystem().getFanEngagementLevel() / 5;

        StringBuilder result = new StringBuilder();
        result.append("=== GAME RESULT ===\n");
        result.append(teamA.getName()).append(" vs ").append(teamB.getName()).append("\n");

        if (skillA > skillB) {
            result.append(teamA.getName()).append(" win!\n");
        } else if (skillB > skillA) {
            result.append(teamB.getName()).append(" win!\n");
        } else {
            result.append("It's a draw!\n");
        }

        result.append("MVP Fan Vote: ").append(selectFanMVP()).append("\n");

        return result.toString();
    }

    private List<String> generateActivitiesForPlayer(Player player) {
        // For now, generate a static schedule. Later this can use player personality, fatigue, etc.
        return Arrays.asList("train", "film", "rest", "social", "random");
    }

    private String selectFanMVP() {
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(teamA.getPlayers());
        allPlayers.addAll(teamB.getPlayers());

        Player best = null;
        int bestScore = -1;

        for (Player p : allPlayers) {
            int score = p.getSkillLevel() + p.getReputation() + (p.getEgoRating() > 50 ? 5 : 0);
            if (score > bestScore) {
                best = p;
                bestScore = score;
            }
        }

        return best != null ? best.getName() : "None";
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public int getCurrentWeek() {
        return currentWeek;
    }
}

