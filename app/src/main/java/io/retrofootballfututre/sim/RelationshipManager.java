public class RelationshipManager {
    private Player player;

    public RelationshipManager(Player player) {
        this.player = player;
    }

    public void developAgentRelationship() {
        if (Math.random() < 0.3) {
            player.logEvent("Bonded with Agent: New endorsement opportunities opened.");
            player.modifyXP("Reputation", 15);
        }
    }

    public void manageFamilyLife() {
        if (player.hasFamily() && Math.random() < 0.2) {
            player.logEvent("Family Moment: Boosted morale and life XP.");
            player.modifyXP("Life", 10);
        }
    }

    public void simulateSocialLife() {
        if (Math.random() < 0.1) {
            player.logEvent("Attended celebrity party: Fame boost!");
            player.modifyXP("Reputation", 10);
            player.applyBuff("Energized", 1);
        }
    }
}
