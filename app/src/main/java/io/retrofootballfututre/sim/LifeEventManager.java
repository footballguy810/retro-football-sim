public class LifeEventManager {
    private Player player;

    public LifeEventManager(Player player) {
        this.player = player;
    }

    public void triggerWeeklyEvents(int week) {
        if (week % 26 == 0) triggerBirthday();
        if (Math.random() < 0.05) triggerRelationshipEvent();
        if (Math.random() < 0.03) triggerInjury();
        if (Math.random() < 0.01) triggerMediaScandal();
    }

    private void triggerBirthday() {
        player.incrementAge();
        player.logEvent("Happy Birthday! Age is now: " + player.getAge());
    }

    private void triggerRelationshipEvent() {
        String[] events = {"Prom", "Fell in Love", "Breakup", "Engaged", "Married", "Child Born"};
        String event = events[(int)(Math.random() * events.length)];
        player.logEvent("Life Event: " + event);
        if (event.equals("Child Born")) player.addLegacy();
    }

    private void triggerInjury() {
        player.logEvent("Injury occurred: Lost 5 Health XP");
        player.modifyXP("Health", -5);
        player.applyBuff("Injured", 2);
    }

    private void triggerMediaScandal() {
        player.logEvent("Media Scandal: Reputation hit, -10 XP");
        player.modifyXP("Reputation", -10);
    }
}
