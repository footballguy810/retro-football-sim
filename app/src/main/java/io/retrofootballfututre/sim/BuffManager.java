package io.retrofootballfuture.sim;

import java.util.*;

public class BuffManager {
    private Map<String, Buff> activeBuffs;
    private Player player;

    public BuffManager(Player player) {
        this.player = player;
        this.activeBuffs = new HashMap<>();
    }

    public void addBuff(Buff buff) {
        if (!activeBuffs.containsKey(buff.getName())) {
            activeBuffs.put(buff.getName(), buff);
            applyBuff(buff);
        }
    }

    public void removeBuff(String buffName) {
        Buff buff = activeBuffs.remove(buffName);
        if (buff != null) {
            unapplyBuff(buff);
        }
    }

    public void updateBuffsWeekly() {
        Iterator<Map.Entry<String, Buff>> iterator = activeBuffs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Buff> entry = iterator.next();
            Buff buff = entry.getValue();
            buff.decreaseDuration();

            if (buff.getDuration() <= 0) {
                unapplyBuff(buff);
                iterator.remove();
            }
        }
    }

    private void applyBuff(Buff buff) {
        switch (buff.getType()) {
            case "MORALE":
                player.setMorale(player.getMorale() + buff.getValue());
                break;
            case "XP_MULTIPLIER":
                player.setXpMultiplier(player.getXpMultiplier() + buff.getValue());
                break;
            case "SKILL_BOOST":
                player.setSkill(player.getSkill() + buff.getValue());
                break;
            case "REPUTATION":
                player.setReputation(player.getReputation() + buff.getValue());
                break;
            case "BRAND":
                player.setBrand(player.getBrand() + buff.getValue());
                break;
            default:
                // unknown type
                break;
        }
    }

    private void unapplyBuff(Buff buff) {
        switch (buff.getType()) {
            case "MORALE":
                player.setMorale(player.getMorale() - buff.getValue());
                break;
            case "XP_MULTIPLIER":
                player.setXpMultiplier(player.getXpMultiplier() - buff.getValue());
                break;
            case "SKILL_BOOST":
                player.setSkill(player.getSkill() - buff.getValue());
                break;
            case "REPUTATION":
                player.setReputation(player.getReputation() - buff.getValue());
                break;
            case "BRAND":
                player.setBrand(player.getBrand() - buff.getValue());
                break;
            default:
                // unknown type
                break;
        }
    }

    public List<Buff> getActiveBuffs() {
        return new ArrayList<>(activeBuffs.values());
    }
}
