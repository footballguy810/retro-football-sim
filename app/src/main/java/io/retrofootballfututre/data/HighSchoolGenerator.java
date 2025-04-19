package io.retrofootballfuture.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HighSchoolGenerator {

    private static final String[] STATES = {
        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
        "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
        "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
        "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
        "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    };

    private static final String[] MASCOTS = {
        "Tigers", "Eagles", "Warriors", "Panthers", "Bulldogs", "Hawks",
        "Lions", "Rams", "Wolves", "Spartans", "Raiders", "Mustangs",
        "Cougars", "Falcons", "Vikings", "Dragons", "Bears", "Gators"
    };

    private static final String[] NAME_PREFIXES = {
        "North", "South", "East", "West", "Central", "River", "Valley", "Lake", "Mountain", "Prairie"
    };

    private static final String[] CITY_NAMES = {
        "Springfield", "Fairview", "Franklin", "Greenville", "Bristol", "Clinton",
        "Salem", "Ashland", "Oakwood", "Dayton", "Florence", "Georgetown", "Lancaster", "Madison"
    };

    private static final String[] SCHOOL_SUFFIXES = {
        "High School", "Prep", "Academy", "Tech", "Magnet"
    };

    private static final String[] ODD_NAMES = {
        "Quantum Flux Academy", "Gravity Prep", "Sentinel Node High"
    };

    private static final Random random = new Random();

    public static void main(String[] args) {
        List<Map<String, String>> schools = new ArrayList<>();
        Map<String, Integer> stateCount = new HashMap<>();

        // Ensure 6 minimum per state
        for (String state : STATES) {
            for (int i = 0; i < 6; i++) {
                schools.add(generateSchool(state));
                stateCount.put(state, stateCount.getOrDefault(state, 0) + 1);
            }
        }

        // Fill up to 400 schools
        while (schools.size() < 400) {
            String state = STATES[random.nextInt(STATES.length)];
            schools.add(generateSchool(state));
            stateCount.put(state, stateCount.getOrDefault(state, 0) + 1);
        }

        // Write to JSON
        try (FileWriter file = new FileWriter("assets/data/high_schools.json")) {
            file.write("[\n");
            for (int i = 0; i < schools.size(); i++) {
                Map<String, String> school = schools.get(i);
                file.write("  {\n");
                file.write("    \"name\": \"" + school.get("name") + "\",\n");
                file.write("    \"location\": \"" + school.get("city") + "\",\n");
                file.write("    \"nickname\": \"" + school.get("mascot") + "\",\n");
                file.write("    \"primaryColor\": \"" + school.get("primaryColor") + "\",\n");
                file.write("    \"secondaryColor\": \"" + school.get("secondaryColor") + "\",\n");
                file.write("    \"state\": \"" + school.get("state") + "\"\n");
                file.write(i < schools.size() - 1 ? "  },\n" : "  }\n");
            }
            file.write("]\n");
            System.out.println("✅ high_schools.json generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, String> generateSchool(String state) {
        Map<String, String> school = new HashMap<>();

        String city = CITY_NAMES[random.nextInt(CITY_NAMES.length)];
        String mascot = MASCOTS[random.nextInt(MASCOTS.length)];
        String primaryColor = getRandomHexColor();
        String secondaryColor = getRandomHexColor();

        String name;
        if (random.nextDouble() < 0.015) { // <2% weird names
            name = ODD_NAMES[random.nextInt(ODD_NAMES.length)];
        } else {
            name = NAME_PREFIXES[random.nextInt(NAME_PREFIXES.length)] + " " +
                   city + " " +
                   SCHOOL_SUFFIXES[random.nextInt(SCHOOL_SUFFIXES.length)];
        }

        school.put("name", name);
        school.put("city", city);
        school.put("mascot", mascot);
        school.put("primaryColor", primaryColor);
        school.put("secondaryColor", secondaryColor);
        school.put("state", state);

        return school;
    }

    private static String getRandomHexColor() {
        int r = random.nextInt(156) + 100; // Avoid very dark colors
        int g = random.nextInt(156) + 100;
        int b = random.nextInt(156) + 100;
        return String.format("#%02X%02X%02X", r, g, b);
    }
}
