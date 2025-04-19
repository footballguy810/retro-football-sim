package ui;

import sim.Player;
import sim.ChoiceEvent;

import java.util.List;
import java.util.Scanner;

public class PlayerChoicesUI {
    Scanner scanner = new Scanner(System.in);

    public void presentChoices(Player player, List<ChoiceEvent> events) {
        System.out.println("🤔 Life Choices for " + player.getName());
        for (int i = 0; i < events.size(); i++) {
            ChoiceEvent event = events.get(i);
            System.out.println((i + 1) + ". " + event.getDescription());
        }

        System.out.print("Pick an option (1–" + events.size() + "): ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= events.size()) {
            events.get(choice - 1).applyOutcome(player);
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
