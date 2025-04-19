package env;

import java.util.List;

public class HighSchool {
    private String name;
    private String city;
    private String state;
    private int footballReputation; // 1–100
    private List<String> alumniToWatch; // Names of players who made it big
    private boolean pipelineToCollege;

    public HighSchool(String name, String city, String state, int footballReputation, List<String> alumniToWatch, boolean pipelineToCollege) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.footballReputation = footballReputation;
        this.alumniToWatch = alumniToWatch;
        this.pipelineToCollege = pipelineToCollege;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public int getFootballReputation() { return footballReputation; }
    public List<String> getAlumniToWatch() { return alumniToWatch; }
    public boolean hasPipelineToCollege() { return pipelineToCollege; }

    public String getLocation() {
        return city + ", " + state;
    }
}
