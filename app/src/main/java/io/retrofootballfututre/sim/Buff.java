package io.retrofootballfuture.sim;

public class Buff {
    private String name;
    private String type; // e.g., MORALE, XP_MULTIPLIER, SKILL_BOOST
    private int value;
    private int duration; // in weeks

    public Buff(String name, String type, int value, int duration) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getDuration() {
        return duration;
    }

    public void decreaseDuration() {
        duration = Math.max(0, duration - 1);
    }
}
