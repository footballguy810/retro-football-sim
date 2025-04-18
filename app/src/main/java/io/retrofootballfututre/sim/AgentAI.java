package io.retrofootballfuture.sim;

public class AgentAI {
    public String negotiateContract(Player player, int teamBudget) {
        int askingPrice = player.getSkill() * 1000 + player.getFame() * 500;
        if (askingPrice <= teamBudget) {
            return "Contract signed at $" + askingPrice;
        } else {
            return "Contract negotiation failed: asking too high.";
        }
    }
}