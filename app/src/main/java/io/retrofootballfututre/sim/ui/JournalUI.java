package ui;

import sim.Player;
import journal.JournalEntry;

import java.util.List;

public class JournalUI {

    public void showJournalEntries(Player player, List<JournalEntry> entries) {
        System.out.println("📖 Journal of " + player.getName());
        for (JournalEntry entry : entries) {
            System.out.println("[" + entry.getCategory() + "] " + entry.getSummary());
        }
    }

    public void addEntry(JournalEntry entry) {
        System.out.println("📝 New journal entry added: " + entry.getSummary());
    }
}
