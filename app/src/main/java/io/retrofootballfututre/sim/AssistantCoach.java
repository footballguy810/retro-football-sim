package io.retrofootballfuture.sim;

public class AssistantCoach {
    private int trainingEffectiveness; // 0–100
    private int disciplineImpact;      // 0–100

    public AssistantCoach() {
        this.trainingEffectiveness = 50 + (int)(Math.random() * 51); // 50–100
        this.disciplineImpact = 50 + (int)(Math.random() * 51);
    }

    public int getTrainingEffectiveness() {
        return trainingEffectiveness;
    }

    public int getDisciplineImpact() {
        return disciplineImpact;
    }

    public String getCoachSummary() {
        return "Training: " + trainingEffectiveness + ", Discipline: " + disciplineImpact;
    }
}
