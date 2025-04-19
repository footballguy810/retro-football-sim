package ui;

import sim.Player;
import sim.ContractOffer;

import java.util.Scanner;

public class ContractNegotiationUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayOffer(Player player, ContractOffer offer) {
        System.out.println("📄 Contract Offer for " + player.getName());
        System.out.println("Team: " + offer.getTeamName());
        System.out.println("Years: " + offer.getYears() + " | Salary: $" + offer.getSalary() + "M/year | Bonuses: $" + offer.getBonus() + "M");

        System.out.print("Do you accept this offer? (yes/no): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            player.signContract(offer);
            System.out.println("✅ Contract signed!");
        } else {
            System.out.println("🛑 Offer rejected.");
        }
    }
}
