package env;

import java.util.List;

public class College {
    private String name;
    private String conference;
    private int prestige; // 1–100
    private List<String> notableAlumni;
    private String coachName;
    private boolean offersNILDeals;
    private String brandIdentity;

    public College(String name, String conference, int prestige, List<String> notableAlumni, String coachName, boolean offersNILDeals, String brandIdentity) {
        this.name = name;
        this.conference = conference;
        this.prestige = prestige;
        this.notableAlumni = notableAlumni;
        this.coachName = coachName;
        this.offersNILDeals = offersNILDeals;
        this.brandIdentity = brandIdentity;
    }

    public String getName() { return name; }
    public String getConference() { return conference; }
    public int getPrestige() { return prestige; }
    public List<String> getNotableAlumni() { return notableAlumni; }
    public String getCoachName() { return coachName; }
    public boolean isOfferingNIL() { return offersNILDeals; }
    public String getBrandIdentity() { return brandIdentity; }

    public String generateRecruitingPitch(String playerName) {
        return "Hey " + playerName + ", come make history at " + name + ". Play under Coach " + coachName + " and become the next legend!";
    }
}
