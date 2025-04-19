package ui;

import sim.Player;
import sim.ScheduleOption;

import java.util.List;
import java.util.Scanner;

public class WeeklySchedulerUI {
    private Scanner scanner = new Scanner(System.in);

    public void displayScheduleOptions(Player player, List<ScheduleOption> options) {
        System.out.println("📅 Weekly Planner - " + player.getName());
        int index = 1;
        for (ScheduleOption opt : options) {
            System.out.println(index++ + ". " + opt.getName() + " (" + opt.getXpCategory() + ") - Cost: " + opt.getTimeCost() + " blocks");
        }

        System.out.println("Select an activity to schedule:");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= options.size()) {
            player.scheduleActivity(options.get(choice - 1));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
