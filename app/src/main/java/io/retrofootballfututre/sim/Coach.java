package io.retrofootballfuture.sim;

import java.util.Random;

public class Coach {
    private String name;
    private String style; // e.g. "Aggressive", "Balanced", "Conservative"
    private int unpredictability; // 0-100, hidden stat affecting consistency
    private AssistantCoach staff;

    public Coach(String name, String style) {
        this.name = name;
        this.style = style;
        this.unpredictability = new Random().nextInt(101); // hidden and random
        this.staff = new AssistantCoach(); // auto-create basic staff
    }

    // === Getters ===
    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public int getUnpredictability() {
        return unpredictability;
    }

    public AssistantCoach getStaff() {
        return staff;
    }

    // === AI Advisor Placeholder ===
    public String getGameAdvice() {
        switch (style) {
            case "Aggressive":
                return "Coach says: Go for it on 4th down!";
            case "Conservative":
                return "Coach says: Punt and trust the defense.";
            default:
                return "Coach says: Let's read the situation.";
        }
    }

    // === Weekly Morale Influence ===
    public int getWeeklyMoraleBoost() {
        int base = 2;
        if (style.equals("Aggressive")) base += 1;
        if (style.equals("Conservative")) base -= 1;

        // Random fluctuation based on unpredictability
        int chaos = new Random().nextInt(unpredictability / 20 + 1); // smaller with lower unpredictability
        return base - chaos;
    }

    // === Play Consistency Penalty (based on unpredictability) ===
    public int getPlayEffectivenessPenalty() {
        return unpredictability / 10; // 0–10% inconsistency
    }
}
