package ui;

import sim.Player;
import sim.Agent;

public class AgentNegotiationUI {

    public void displayAgentIntro(Agent agent) {
        System.out.println("🤝 Meet your agent: " + agent.getName());
        System.out.println("Specialty: " + agent.getNegotiationStyle());
    }

    public void negotiateContract(Player player, Agent agent) {
        System.out.println("📑 Contract Negotiation in progress for " + player.getName());
        System.out.println("Agent is pushing for: $" + agent.proposeSalary(player));
        System.out.println("Player Current Reputation: " + player.getReputation());
        // Add input logic later or pass through negotiation engine
    }
}
