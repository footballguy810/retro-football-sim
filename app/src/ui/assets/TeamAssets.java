package ui.assets;

import java.util.HashMap;

public class TeamAssets {
    private static final HashMap<String, String> logos = new HashMap<>();
    private static final HashMap<String, String[]> colors = new HashMap<>();

    static {
        // Load some default teams
        logos.put("Chicago Storm", "res/images/teams/chicago_storm.png");
        colors.put("Chicago Storm", new String[]{"#1C1C1C", "#00BFFF"});

        logos.put("Houston Blaze", "res/images/teams/houston_blaze.png");
        colors.put("Houston Blaze", new String[]{"#8B0000", "#FFA500"});
    }

    public static String getLogoPath(String teamName) {
        return logos.getOrDefault(teamName, "res/images/teams/default_logo.png");
    }

    public static String[] getColors(String teamName) {
        return colors.getOrDefault(teamName, new String[]{"#CCCCCC", "#666666"});
    }
}
