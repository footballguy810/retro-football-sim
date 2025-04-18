package io.retrofootballfuture.sim;

import java.util.ArrayList;

public class Team {
    private String name;
    private String location;
    private String ownerName;
    private int teamReputation;
    private int morale;
    private int marketRating;
    private int fanBase;
    private int budget;
    private int revenue;

    private int wins;
    private int losses;
    private int ties;
    private int winStreak;

    private Coach coach;
    private ArrayList<Player> players;

    public Team(String name, String location, String ownerName, Coach coach) {
        this.name = name;
        this.location = location;
        this.ownerName = ownerName;
        this.coach = coach;
        this.players = new ArrayList<>();

        this.teamReputation = 50; // neutral start
        this.morale = 70;         // slightly optimistic
        this.marketRating = (int) (Math.random() * 100);
        this.fanBase = 1000 + (int) (Math.random() * 9000);
        this.budget = 10000000;  // $10M starter
        this.revenue = 0;

        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.winStreak = 0;
    }

    // === Roster Management ===
    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    // === Team Rating ===
    public int getTeamSkill() {
        int total = 0;
        for (Player player : players) {
            total += player.getSkillLevel();
        }
        return players.size() > 0 ? total / players.size() : 0;
    }

    // === Morale System ===
    public void updateMorale(boolean wonGame) {
        if (wonGame) {
            morale += 5;
            winStreak++;
        } else {
            morale -= 5;
            winStreak = 0;
        }

        morale = Math.max(0, Math.min(morale, 100));
    }

    public int getMorale() {
        return morale;
    }

    // === Fan System ===
    public void growFanbase() {
        fanBase += 100 + (int) (Math.random() * 200);
        revenue += fanBase * (marketRating / 100);
    }

    public void loseFans() {
        fanBase -= 200 + (int) (Math.random() * 300);
        fanBase = Math.max(fanBase, 100); // don't drop below 100
    }

    // === Stats ===
    public void recordGameResult(boolean win, boolean tie) {
        if (tie) {
            ties++;
        } else if (win) {
            wins++;
            updateMorale(true);
            growFanbase();
        } else {
            losses++;
            updateMorale(false);
            loseFans();
        }
    }

    public String getRecord() {
        return wins + "-" + losses + "-" + ties;
    }

    public int getWinStreak() {
        return winStreak;
    }

    // === Financials ===
    public void updateRevenue(int amount) {
        revenue += amount;
    }

    public int getRevenue() {
        return revenue;
    }

    public int getBudget() {
        return budget;
    }

    public void spendBudget(int amount) {
        budget -= amount;
    }

    // === Identity & Coach ===
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Coach getCoach() {
        return coach;
    }

    public String getOwnerName() {
        return ownerName;
    }

    // === Reputation ===
    public int getTeamReputation() {
        return teamReputation;
    }

    public void boostReputation(int amount) {
        teamReputation += amount;
        teamReputation = Math.min(100, teamReputation);
    }

    public void hurtReputation(int amount) {
        teamReputation -= amount;
        teamReputation = Math.max(0, teamReputation);
    }

    // === Market and Fans ===
    public int getMarketRating() {
        return marketRating;
    }

    public int getFanBase() {
        return fanBase;
    }
}
