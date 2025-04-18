package io.retrofootballfuture.sim.recruiting;

import io.retrofootballfuture.sim.player.Player;
import io.retrofootballfuture.sim.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecruitingPitches {

    private static final Random random = new Random();

    public static List<String> generatePitches(Player player, Team school) {
        List<String> pitches = new ArrayList<>();
        String playerName = player.getName();
        String schoolName = school.getName();
        int ego = player.getEgo();
        int loyalty = player.getLoyalty();
        int brand = player.getBrandRating();
        String hometown = player.getHometown();
        String region = school.getRegion(); // assume school has region property

        // Personality-driven pitch selection
        if (ego > 80 && brand > 70) {
            pitches.add("Become the face of " + schoolName + " with national exposure and brand deals.");
        }

        if (loyalty > 75 && hometown.equalsIgnoreCase(region)) {
            pitches.add("Play for your community and inspire the next generation right here in " + region + ".");
        }

        if (player.getMorale() < 40) {
            pitches.add("We take care of our players like family. At " + schoolName + ", you'll be supported every step of the way.");
        }

        if (player.getSkillLevel() > 85) {
            pitches.add("You're NFL material. Join " + schoolName + " and we'll get you draft-ready.");
        }

        if (player.getMentalXp() > 70) {
            pitches.add("Our academic program is top-tier. You'll graduate ready for life after football.");
        }

        // NIL Deal Simulation
        if (random.nextDouble() < 0.4) {
            pitches.add("We've secured NIL deals worth over $100k for star players. Your future starts here.");
        }

        // Hometown Hero pitch
        if (player.getHometown().equalsIgnoreCase(region)) {
            pitches.add("Be a hometown hero and lead " + schoolName + " to glory right where you grew up.");
        }

        // Legacy pitch
        if (player.getName().contains("Jr.") || player.getName().contains("III")) {
            pitches.add("Continue your family legacy at " + schoolName + ". The name " + playerName + " belongs here.");
        }

        // Winning culture
        if (school.getWinHistory() > 75) {
            pitches.add("Winning is in our blood. Join a championship culture at " + schoolName + ".");
        }

        // Unique immersive pitch events
        int eventRoll = random.nextInt(100);
        if (eventRoll < 20) {
            pitches.add("Come meet our celebrity alumni this weekend. You’re invited to a private campus tour.");
        } else if (eventRoll < 40) {
            pitches.add("A packed pep rally just chanted your name. Fans here already love you.");
        }

        return pitches;
    }
}
