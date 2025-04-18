package io.retrofootballfuture.sim;

import java.util.*;

public class BadgeManager {
    private Player player;
    private Map<String, Badge> earnedBadges;

    public BadgeManager(Player player) {
        this.player = player;
        this.earnedBadges = new HashMap<>();
    }

    public void earnBadge(Badge badge) {
        if (!earnedBadges.containsKey(badge.getName())) {
            earnedBadges.put(badge.getName(), badge);
            applyBadgeEffects(badge);
        }
    }

    public void removeBadge(String badgeName) {
        if (earnedBadges.containsKey(badgeName)) {
            Badge badge = earnedBadges.remove(badgeName);
            removeBadgeEffects(badge);
        }
    }

    public void upgradeBadge(String badgeName) {
        Badge badge = earnedBadges.get(badgeName);
        if (badge != null && badge.canUpgrade()) {
            removeBadgeEffects(badge); // remove current effect
            badge.upgrade();           // upgrade badge
            applyBadgeEffects(badge);  // reapply new effect
        }
    }

    private void applyBadgeEffects(Badge badge) {
        switch (badge.getType()) {
            case "XP_BOOST":
                player.setXpMultiplier(player.getXpMultiplier() + badge.getEffectValue());
                break;
            case "MORALE":
                player.setMorale(player.getMorale() + badge.getEffectValue());
                break;
            case "REPUTATION":
                player.setReputation(player.getReputation() + badge.getEffectValue());
                break;
            case "BRAND":
                player.setBrand(player.getBrand() + badge.getEffectValue());
                break;
            case "FAN_FAVORITE":
                player.adjustFanSupport(badge.getEffectValue());
                break;
            case "HEALTH":
                player.increaseHealthCap(badge.getEffectValue());
                break;
            default:
                break;
        }
    }

    private void removeBadgeEffects(Badge badge) {
        switch (badge.getType()) {
            case "XP_BOOST":
                player.setXpMultiplier(player.getXpMultiplier() - badge.getEffectValue());
                break;
            case "MORALE":
                player.setMorale(player.getMorale() - badge.getEffectValue());
                break;
            case "REPUTATION":
                player.setReputation(player.getReputation() - badge.getEffectValue());
                break;
            case "BRAND":
                player.setBrand(player.getBrand() - badge.getEffectValue());
                break;
            case "FAN_FAVORITE":
                player.adjustFanSupport(-badge.getEffectValue());
                break;
            case "HEALTH":
                player.decreaseHealthCap(badge.getEffectValue());
                break;
            default:
                break;
        }
    }

    public List<Badge> getEarnedBadges() {
        return new ArrayList<>(earnedBadges.values());
    }

    public boolean hasBadge(String name) {
        return earnedBadges.containsKey(name);
    }

    public void weeklyBadgeCheck() {
        for (Badge badge : earnedBadges.values()) {
            badge.weeklyUpdate(); // handles time-limited or progressive badges
        }
    }
}
