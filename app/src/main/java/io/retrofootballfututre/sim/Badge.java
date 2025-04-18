package io.retrofootballfuture.sim;

public class Badge {
    private String name;
    private String type; // XP_BOOST, MORALE, BRAND, etc.
    private int effectValue;
    private int level;
    private int maxLevel;
    private boolean temporary;
    private int duration;

    public Badge(String name, String type, int effectValue, int maxLevel, boolean temporary, int duration) {
        this.name = name;
        this.type = type;
        this.effectValue = effectValue;
        this.level = 1;
        this.maxLevel = maxLevel;
        this.temporary = temporary;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getEffectValue() {
        return effectValue * level;
    }

    public boolean canUpgrade() {
        return level < maxLevel;
    }

    public void upgrade() {
        if (canUpgrade()) {
            level++;
        }
    }

    public void weeklyUpdate() {
        if (temporary) {
            duration--;
        }
    }

    public boolean isExpired() {
        return temporary && duration <= 0;
    }
}
