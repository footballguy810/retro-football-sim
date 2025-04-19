package ui;

import sim.Recruit;
import sim.RecruitingPitch;

import java.util.List;

public class RecruitingBoardUI {
    public void showRecruitingTargets(List<Recruit> recruits) {
        System.out.println("📋 Recruiting Board:");
        for (int i = 0; i < recruits.size(); i++) {
            Recruit r = recruits.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " - Pos: " + r.getPosition() + " - Rating: " + r.getOverallRating() + " - Interest: " + r.getInterestLevel());
        }
    }

    public void showRecruitingPitch(Recruit recruit, List<RecruitingPitch> pitches) {
        System.out.println("🎤 Pitches for " + recruit.getName() + ":");
        for (RecruitingPitch pitch : pitches) {
            System.out.println("- " + pitch.getCategory() + ": " + pitch.getValue());
        }
    }
}
