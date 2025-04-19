package ui;

import sim.Player;
import sim.Mentor;

public class MentorshipUI {

    public void showMentorshipOptions(Player player, Mentor[] mentors) {
        System.out.println("🧭 Choose a Mentor for " + player.getName());
        for (int i = 0; i < mentors.length; i++) {
            System.out.println((i + 1) + ". " + mentors[i].getName() + " - " + mentors[i].getSpecialty());
        }
    }

    public void applyMentorship(Player player, Mentor mentor) {
        System.out.println("📈 " + mentor.getName() + " is now mentoring " + player.getName());
        System.out.println("Benefits: " + mentor.getBoostDescription());
        mentor.boostPlayer(player);
    }
}
