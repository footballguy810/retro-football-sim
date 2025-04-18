// Player.java - Updated Full Version with All Features
package io.retrofootballfuture.sim;

import java.util.*;

public class Player {
    private String name;
    private int age;
    private String position;
    private int skill;

    private int morale;
    private int stamina;
    private int fatigue;

    private int reputation;
    private int brand;
    private int ego;

    private List<Buff> activeBuffs;
    private List<Badge> earnedBadges;

    private EnumMap<XPType, Integer> xpMap;
    private List<Milestone> milestones;
    private List<Injury> injuries;
    private List<Relationship> relationships;

    private Agent agent;
    private List<String> careerTimeline;
    private boolean retired;

    public Player(String name, int age, String position, int skill) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.skill = skill;
        this.morale = 70;
        this.stamina = 100;
        this.fatigue = 0;
        this.reputation = 0;
        this.brand = 0;
        this.ego = 0;
        this.activeBuffs = new ArrayList<>();
        this.earnedBadges = new ArrayList<>();
        this.xpMap = new EnumMap<>(XPType.class);
        for (XPType type : XPType.values()) xpMap.put(type, 0);
        this.milestones = new ArrayList<>();
        this.injuries = new ArrayList<>();
        this.relationships = new ArrayList<>();
        this.agent = new Agent("Default Agent", AgentStyle.BALANCED);
        this.careerTimeline = new ArrayList<>();
        this.retired = false;
    }

    public void gainXP(XPType type, int amount) {
        xpMap.put(type, xpMap.get(type) + amount);
    }

    public void applyBuff(Buff buff) {
        activeBuffs.add(buff);
    }

    public void earnBadge(Badge badge) {
        earnedBadges.add(badge);
    }

    public void adjustMorale(int delta) {
        morale = Math.max(0, Math.min(100, morale + delta));
    }

    public void increaseFatigue(int amount) {
        fatigue = Math.min(100, fatigue + amount);
        stamina = Math.max(0, stamina - amount);
        if (fatigue > 80 && Math.random() < 0.3) {
            Injury injury = new Injury("Muscle Strain", 2);
            injuries.add(injury);
            morale -= 10;
        }
    }

    public void addMilestone(String name, String effect) {
        milestones.add(new Milestone(name, effect));
        careerTimeline.add("Milestone: " + name);
    }

    public void buildRelationship(String name, String type, int bond) {
        relationships.add(new Relationship(name, type, bond));
    }

    public void updateBrandAndReputation(int brandChange, int repChange) {
        brand += brandChange;
        reputation += repChange;
    }

    public void interactWithAgent(String decision) {
        careerTimeline.add("Agent decision: " + decision);
        agent.react(decision);
    }

    public void retire() {
        retired = true;
        careerTimeline.add("Retired at age " + age);
    }

    // Getters, Setters, and Game Simulation Logic ...

    public String getSummary() {
        return name + ", Age: " + age + ", Pos: " + position +
               ", Skill: " + skill + ", XP: " + xpMap.toString();
    }
}

// XPType.java
enum XPType {
    SKILL, MENTAL, LIFE, HEALTH, REPUTATION
}

// Buff.java
class Buff {
    public String name;
    public String effect;
    public int durationWeeks;

    public Buff(String name, String effect, int durationWeeks) {
        this.name = name;
        this.effect = effect;
        this.durationWeeks = durationWeeks;
    }
}

// Badge.java
class Badge {
    public String name;
    public String description;

    public Badge(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

// Milestone.java
class Milestone {
    public String name;
    public String effect;

    public Milestone(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }
}

// Injury.java
class Injury {
    public String type;
    public int weeksOut;

    public Injury(String type, int weeksOut) {
        this.type = type;
        this.weeksOut = weeksOut;
    }
}

// Relationship.java
class Relationship {
    public String name;
    public String type; // friend, spouse, rival, etc.
    public int bondStrength;

    public Relationship(String name, String type, int bondStrength) {
        this.name = name;
        this.type = type;
        this.bondStrength = bondStrength;
    }
}

// Agent.java
class Agent {
    public String name;
    public AgentStyle style;

    public Agent(String name, AgentStyle style) {
        this.name = name;
        this.style = style;
    }

    public void react(String decision) {
        // affect morale, brand, negotiation outcomes
    }
}

// AgentStyle.java
enum AgentStyle {
    AGGRESSIVE, CONSERVATIVE, BALANCED
}
