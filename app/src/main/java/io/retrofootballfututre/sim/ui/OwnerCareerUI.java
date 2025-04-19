package ui;

import sim.Owner;
import sim.Team;

import java.util.Scanner;

public class OwnerCareerUI {
    private Scanner scanner;

    public OwnerCareerUI() {
        scanner = new Scanner(System.in);
    }

    public void showOwnerMenu(Owner owner) {
        System.out.println("=== Owner Career: " + owner.getName() + " ===");
        System.out.println("Team: " + (owner.getOwnedTeam() != null ? owner.getOwnedTeam().getName() : "None"));
        System.out.println("Balance: $" + owner.getNetWorth() + "M");
        System.out.println("1. View Finances");
        System.out.println("2. Vote on League Rules");
        System.out.println("3. Hire Executives");
        System.out.println("4. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showFinances(owner);
                break;
            case 2:
                System.out.println("Rule proposals will appear in offseason.");
                break;
            case 3:
                System.out.println("Executive hiring not yet implemented.");
                break;
            default:
                break;
        }
    }

    private void showFinances(Owner owner) {
        System.out.println("Income: $" + owner.getIncome() + "M");
        System.out.println("Expenses: $" + owner.getExpenses() + "M");
        System.out.println("Sponsorships: " + owner.getSponsorships());
    }
}
