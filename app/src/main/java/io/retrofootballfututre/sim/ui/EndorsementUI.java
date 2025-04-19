package ui;

import sim.Player;
import sim.Endorsement;

import java.util.List;
import java.util.Scanner;

public class EndorsementUI {
    private Scanner scanner = new Scanner(System.in);

    public void showEndorsements(Player player) {
        System.out.println("💼 Endorsements for " + player.getName());
        List<Endorsement> deals = player.getEndorsements();
        for (Endorsement e : deals) {
            System.out.println(e.getBrandName() + " - $" + e.getPayout() + "M - " + e.getDescription());
        }

        System.out.println("1. Accept New Deal");
        System.out.println("2. Drop Endorsement");
        System.out.println("3. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("New offer logic not yet implemented.");
                break;
            case 2:
                System.out.println("Cancel logic coming soon.");
                break;
            default:
                break;
        }
    }
}
