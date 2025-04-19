package com.retrofootballfuture.data;

import java.util.List;

public class CollegeTeamData {

    public static class CollegeTeam {
        public String name;
        public String location;
        public String nickname;
        public String primaryColor;
        public String secondaryColor;
        public String rival;

        public CollegeTeam(String name, String location, String nickname, String primaryColor, String secondaryColor, String rival) {
            this.name = name;
            this.location = location;
            this.nickname = nickname;
            this.primaryColor = primaryColor;
            this.secondaryColor = secondaryColor;
            this.rival = rival;
        }
    }

    List<College> colleges = List.of(
    new College("Solstice University", "Solstice", "Flames", "#FF6347", "#FFDAB9", "Borealis Academy", "California"),
    new College("Borealis Academy", "Borealis", "Auroras", "#1E90FF", "#D8BFD8", "Solstice University", "Alaska"),
    new College("Titan Tech", "Elysium", "Titans", "#708090", "#F0E68C", "Obsidian State", "Nevada"),
    new College("Obsidian State", "Obsidian", "Crags", "#2F4F4F", "#A9A9A9", "Titan Tech", "Arizona"),
    new College("Crimson Forge", "Furnace", "Forgers", "#DC143C", "#8B0000", "Ironwood Institute", "Texas"),
    new College("Ironwood Institute", "Ironwood", "Anvils", "#B22222", "#CD5C5C", "Crimson Forge", "Texas"),
    new College("Frost Valley University", "Glacier Bay", "Frostwolves", "#00BFFF", "#E0FFFF", "Arctic Dominion", "Montana"),
    new College("Arctic Dominion", "Northreach", "Winds", "#4682B4", "#B0C4DE", "Frost Valley University", "Alaska"),
    new College("Crescent Bay University", "Crescent Bay", "Seastars", "#4169E1", "#87CEFA", "Golden Coast College", "California"),
    new College("Golden Coast College", "Sonoma Shore", "Tides", "#20B2AA", "#B0E0E6", "Crescent Bay University", "California"),
    new College("Prairie Ridge University", "Great Plains", "Buffs", "#DAA520", "#F5DEB3", "Timberland State", "Kansas"),
    new College("Timberland State", "Boar Hollow", "Boars", "#556B2F", "#8FBC8F", "Prairie Ridge University", "Arkansas"),
    new College("Liberty Heights College", "New Liberty", "Eagles", "#00008B", "#B22222", "Commonwealth University", "Virginia"),
    new College("Commonwealth University", "Columbia City", "Commons", "#8B008B", "#FFD700", "Liberty Heights College", "Maryland"),
    new College("Mariner’s Institute", "Port Locke", "Mariners", "#191970", "#ADD8E6", "Northshore State", "Maine"),
    new College("Northshore State", "Bayfield", "Buoys", "#468499", "#AFEEEE", "Mariner’s Institute", "Massachusetts"),
    new College("Sierra Crest University", "Highpass", "Goats", "#708090", "#C0C0C0", "Cascade State", "Colorado"),
    new College("Cascade State", "Cascade City", "Falcons", "#2E8B57", "#98FB98", "Sierra Crest University", "Oregon"),
    new College("Canyon Rock College", "Redlands", "Raptors", "#A52A2A", "#DEB887", "Dust Valley Tech", "Utah"),
    new College("Dust Valley Tech", "Drybend", "Scorchers", "#B87333", "#FFD700", "Canyon Rock College", "New Mexico")
);
colleges.addAll(List.of(
    new College("Emerald Bay University", "Seaglen", "Sharks", "#008080", "#40E0D0", "Crimson Sound College", "Florida"),
    new College("Crimson Sound College", "Deepgulf", "Barracudas", "#B22222", "#FFA07A", "Emerald Bay University", "Louisiana"),
    new College("Thunder Ridge Tech", "Storm Bluff", "Bolts", "#1C1C1C", "#FFD700", "Rainshadow University", "Oklahoma"),
    new College("Rainshadow University", "Mist Creek", "Shadows", "#2F4F4F", "#A9A9A9", "Thunder Ridge Tech", "Washington"),
    new College("Great Iron College", "Forge City", "Steelmen", "#808080", "#C0C0C0", "Rustbelt Tech", "Ohio"),
    new College("Rustbelt Tech", "Mill Junction", "Scraps", "#B87333", "#DAA520", "Great Iron College", "Pennsylvania"),
    new College("Glacier Summit", "Icerock", "Yetis", "#E0FFFF", "#4682B4", "Snowpoint Academy", "Wyoming"),
    new College("Snowpoint Academy", "Snowridge", "Frostbites", "#B0E0E6", "#AFEEEE", "Glacier Summit", "Idaho"),
    new College("Sunbelt Union", "Sunspire", "Suns", "#FFD700", "#FFA500", "Sandstorm State", "New Mexico"),
    new College("Sandstorm State", "Cactus Hollow", "Dustdevils", "#F4A460", "#D2B48C", "Sunbelt Union", "Arizona"),
    new College("Delta Southern University", "Riverbend", "Catfish", "#6495ED", "#B0C4DE", "Bayou Tech", "Mississippi"),
    new College("Bayou Tech", "Marshline", "Gators", "#228B22", "#98FB98", "Delta Southern University", "Louisiana"),
    new College("Granite Hill College", "Stonemarch", "Rhinos", "#696969", "#D3D3D3", "Crater State", "Nevada"),
    new College("Crater State", "Ashrock", "Blazers", "#8B0000", "#FF6347", "Granite Hill College", "Utah"),
    new College("Bluegrass University", "Lexview", "Stallions", "#4169E1", "#87CEFA", "Ironleaf College", "Kentucky"),
    new College("Ironleaf College", "Oakrest", "Elks", "#556B2F", "#6B8E23", "Bluegrass University", "Tennessee"),
    new College("Highspire Tech", "Nova Hills", "Spirehawks", "#9932CC", "#DDA0DD", "Brightmoon College", "West Virginia"),
    new College("Brightmoon College", "Moonridge", "Owls", "#4B0082", "#BA55D3", "Highspire Tech", "Virginia"),
    new College("Red River University", "Riverton", "Coyotes", "#A52A2A", "#F08080", "Twin Buttes College", "Texas"),
    new College("Twin Buttes College", "Mesa View", "Bulls", "#8B4513", "#DEB887", "Red River University", "Texas")
));
collegeTeams.add(new CollegeTeam("Liberty University", "Lynchburg", "Flames", "#990000", "#FFFFFF", "Old Dominion University", "VA"));
collegeTeams.add(new CollegeTeam("Sam Houston State", "Huntsville", "Bearkats", "#F58025", "#003057", "Stephen F. Austin", "TX"));
collegeTeams.add(new CollegeTeam("Eastern Michigan", "Ypsilanti", "Eagles", "#006633", "#A2AAAD", "Central Michigan", "MI"));
collegeTeams.add(new CollegeTeam("Middle Tennessee", "Murfreesboro", "Blue Raiders", "#0066CC", "#FFFFFF", "Western Kentucky", "TN"));
collegeTeams.add(new CollegeTeam("Florida Atlantic", "Boca Raton", "Owls", "#003366", "#CC0000", "FIU", "FL"));
collegeTeams.add(new CollegeTeam("Florida International", "Miami", "Panthers", "#002D62", "#C5960C", "Florida Atlantic", "FL"));
collegeTeams.add(new CollegeTeam("Western Kentucky", "Bowling Green", "Hilltoppers", "#BA0C2F", "#FFFFFF", "Middle Tennessee", "KY"));
collegeTeams.add(new CollegeTeam("North Texas", "Denton", "Mean Green", "#00853E", "#000000", "UTSA", "TX"));
collegeTeams.add(new CollegeTeam("UTSA", "San Antonio", "Roadrunners", "#002244", "#F47321", "North Texas", "TX"));
collegeTeams.add(new CollegeTeam("Louisiana Tech", "Ruston", "Bulldogs", "#005BAC", "#E41B17", "ULM", "LA"));
collegeTeams.add(new CollegeTeam("UAB", "Birmingham", "Blazers", "#006341", "#A89968", "Troy", "AL"));
collegeTeams.add(new CollegeTeam("Rice", "Houston", "Owls", "#00205B", "#A2AAAD", "Houston", "TX"));
collegeTeams.add(new CollegeTeam("Charlotte", "Charlotte", "49ers", "#046A38", "#A2AAAD", "Appalachian State", "NC"));
collegeTeams.add(new CollegeTeam("Old Dominion University", "Norfolk", "Monarchs", "#003057", "#A2AAAD", "Liberty University", "VA"));
collegeTeams.add(new CollegeTeam("Marshall", "Huntington", "Thundering Herd", "#00703C", "#A2AAAD", "Appalachian State", "WV"));
collegeTeams.add(new CollegeTeam("Southern Miss", "Hattiesburg", "Golden Eagles", "#FDB827", "#000000", "Tulane", "MS"));
collegeTeams.add(new CollegeTeam("Appalachian State", "Boone", "Mountaineers", "#222222", "#FFCC00", "Marshall", "NC"));
collegeTeams.add(new CollegeTeam("Coastal Carolina", "Conway", "Chanticleers", "#006666", "#B4975A", "Appalachian State", "SC"));
collegeTeams.add(new CollegeTeam("Georgia Southern", "Statesboro", "Eagles", "#041E42", "#A2AAAD", "Georgia State", "GA"));
collegeTeams.add(new CollegeTeam("Georgia State", "Atlanta", "Panthers", "#0039A6", "#A2AAAD", "Georgia Southern", "GA"));
collegeTeams.add(new CollegeTeam("Arkansas State", "Jonesboro", "Red Wolves", "#CC092F", "#000000", "Louisiana", "AR"));
collegeTeams.add(new CollegeTeam("Louisiana", "Lafayette", "Ragin' Cajuns", "#D30010", "#231F20", "Louisiana Tech", "LA"));
collegeTeams.add(new CollegeTeam("South Alabama", "Mobile", "Jaguars", "#C8102E", "#00205B", "Troy", "AL"));
collegeTeams.add(new CollegeTeam("Texas State", "San Marcos", "Bobcats", "#501214", "#BC9B6A", "UTSA", "TX"));
collegeTeams.add(new CollegeTeam("Troy", "Troy", "Trojans", "#8A2432", "#A2AAAD", "UAB", "AL"));
collegeTeams.add(new CollegeTeam("ULM", "Monroe", "Warhawks", "#810029", "#A2AAAD", "Louisiana Tech", "LA"));
collegeTeams.add(new CollegeTeam("Ball State", "Muncie", "Cardinals", "#BA0C2F", "#000000", "Toledo", "IN"));
collegeTeams.add(new CollegeTeam("Bowling Green", "Bowling Green", "Falcons", "#331E54", "#FF6A13", "Toledo", "OH"));
collegeTeams.add(new CollegeTeam("Buffalo", "Buffalo", "Bulls", "#005BBB", "#FFFFFF", "Kent State", "NY"));
collegeTeams.add(new CollegeTeam("Central Michigan", "Mount Pleasant", "Chippewas", "#6A0032", "#FFCC00", "Western Michigan", "MI"));
collegeTeams.add(new CollegeTeam("Kent State", "Kent", "Golden Flashes", "#00205B", "#FFC72C", "Akron", "OH"));
collegeTeams.add(new CollegeTeam("Miami (OH)", "Oxford", "RedHawks", "#B61E2E", "#A2AAAD", "Ohio", "OH"));
collegeTeams.add(new CollegeTeam("Northern Illinois", "DeKalb", "Huskies", "#CC0000", "#000000", "Toledo", "IL"));
collegeTeams.add(new CollegeTeam("Ohio", "Athens", "Bobcats", "#00694E", "#A2AAAD", "Miami (OH)", "OH"));
collegeTeams.add(new CollegeTeam("Toledo", "Toledo", "Rockets", "#00205B", "#FFCD00", "Bowling Green", "OH"));
collegeTeams.add(new CollegeTeam("Western Michigan", "Kalamazoo", "Broncos", "#462C45", "#A89968", "Central Michigan", "MI"));
collegeTeams.add(new CollegeTeam("Akron", "Akron", "Zips", "#041E42", "#A2AAAD", "Kent State", "OH"));
collegeTeams.add(new CollegeTeam("UMass", "Amherst", "Minutemen", "#881C1C", "#A2AAAD", "Army", "MA"));
collegeTeams.add(new CollegeTeam("Cascade State", "Bend", "Storm", "#1E3F66", "#A8DADC", "Sierra Tech", "OR"));
collegeTeams.add(new CollegeTeam("Sierra Tech", "Reno", "Coyotes", "#264653", "#F4A261", "Cascade State", "NV"));
collegeTeams.add(new CollegeTeam("Atlantic Harbor University", "Portsmouth", "Mariners", "#0077B6", "#CAF0F8", "Coastal Carolina", "VA"));
collegeTeams.add(new CollegeTeam("Great Plains Tech", "Lincoln", "Bison", "#556B2F", "#FFD700", "Midwest A&M", "NE"));
collegeTeams.add(new CollegeTeam("Midwest A&M", "Springfield", "Harvesters", "#9A6324", "#FFD8B1", "Great Plains Tech", "MO"));
collegeTeams.add(new CollegeTeam("Suncoast University", "Tampa", "Barracudas", "#008891", "#FFD369", "Florida International", "FL"));
