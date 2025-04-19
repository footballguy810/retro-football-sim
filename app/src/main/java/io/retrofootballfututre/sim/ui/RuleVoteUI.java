package ui;

import sim.Owner;
import sim.RuleProposal;

import java.util.List;

public class RuleVoteUI {

    public void displayProposals(List<RuleProposal> proposals) {
        System.out.println("📜 League Rule Proposals:");
        for (RuleProposal proposal : proposals) {
            System.out.println("- " + proposal.getTitle() + ": " + proposal.getDescription());
        }
    }

    public void castVote(Owner owner, RuleProposal proposal, boolean vote) {
        System.out.println("🗳️ " + owner.getName() + " voted " + (vote ? "YES" : "NO") + " on '" + proposal.getTitle() + "'");
        proposal.registerVote(owner, vote);
    }
}
