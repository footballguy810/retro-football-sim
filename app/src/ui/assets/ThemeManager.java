package ui.assets;

import java.awt.Color;

public class ThemeManager {
    public static Color getTeamPrimaryColor(String teamName) {
        switch (teamName.toLowerCase()) {
            case "chicago storm":
                return new Color(0x00BFFF);
            case "houston blaze":
                return new Color(0xFF4500);
            default:
                return Color.GRAY;
        }
    }

    public static Color getBackgroundColor() {
        return new Color(0x101820);
    }
}
