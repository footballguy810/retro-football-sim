package ui;

import sim.Coach;
import sim.Team;

import java.util.Scanner;

public class CoachCareerUI {
    private Scanner scanner;

    public CoachCareerUI() {
        scanner = new Scanner(System.in);
    }

    public void showCoachMenu(Coach coach) {
        System.out.println("=== Coach Career: " + coach.getName() + " ===");
        System.out.println("Team: " + coach.getTeam().getName());
        System.out.println("Style: " + coach.getStyle());
        System.out.println("1. Set Training Focus");
        System.out.println("2. Manage Staff");
        System.out.println("3. Review Performance");
        System.out.println("4. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                setTrainingFocus(coach);
                break;
            case 2:
                System.out.println("Assistant/staff management coming soon.");
                break;
            case 3:
                System.out.println("Coach Win %: " + coach.getWinRate());
                break;
            default:
                break;
        }
    }

    private void setTrainingFocus(Coach coach) {
        System.out.println("Choose focus: 1. Offense  2. Defense  3. Balance");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                coach.setTrainingFocus("Offense");
                break;
            case 2:
                coach.setTrainingFocus("Defense");
                break;
            case 3:
                coach.setTrainingFocus("Balanced");
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
}
