package assets;

import java.util.Arrays;
import java.util.List;

public class TeamData {
    public static class Team {
        public String city;
        public String name;
        public String logo;
        public String primaryColor;
        public String secondaryColor;

        public Team(String city, String name, String logo, String primaryColor, String secondaryColor) {
            this.city = city;
            this.name = name;
            this.logo = logo;
            this.primaryColor = primaryColor;
            this.secondaryColor = secondaryColor;
        }
    }

    public static List<Team> getAllTeams() {
        return Arrays.asList(
            new Team("Salem", "Witches", "salem_witches.png", "#4B0082", "#FF4500"),
            new Team("Tulsa", "Black Wall", "tulsa_blackwall.png", "#000000", "#FFD700"),
            new Team("Rochester", "Suffragists", "rochester_suffragists.png", "#9400D3", "#D3D3D3"),
            new Team("Birmingham", "Bombers", "birmingham_bombers.png", "#800000", "#F5DEB3"),
            new Team("San Juan", "Corsairs", "sanjuan_corsairs.png", "#4169E1", "#20B2AA"),
            new Team("Savannah", "Greycoats", "savannah_greycoats.png", "#696969", "#B22222"),
            new Team("Cleveland", "Rockers", "cleveland_rockers.png", "#800080", "#DAA520"),
            new Team("Boise", "Trailmen", "boise_trailmen.png", "#8B4513", "#4682B4"),
            new Team("Baltimore", "Poes", "baltimore_poes.png", "#000000", "#800080"),
            new Team("San Antonio", "Remember", "sanantonio_remember.png", "#B22222", "#DCDCDC"),
            new Team("New Haven", "Yellers", "newhaven_yellers.png", "#003366", "#FFCC00"),
            new Team("Pittsburgh", "Carnegies", "pittsburgh_carnegies.png", "#2F4F4F", "#DAA520"),
            new Team("Minneapolis", "Lakesmen", "minneapolis_lakesmen.png", "#1E90FF", "#228B22"),
            new Team("Fresno", "Dust", "fresno_dust.png", "#DEB887", "#8B0000"),
            new Team("Augusta", "Rebels", "augusta_rebels.png", "#556B2F", "#708090"),
            new Team("Santa Fe", "Mirages", "santafe_mirages.png", "#FF8C00", "#2E8B57"),
            new Team("Louisville", "Braids", "louisville_braids.png", "#D2691E", "#000000"),
            new Team("Oakland", "Panthers", "oakland_panthers.png", "#000000", "#DC143C"),
            new Team("Anchorage", "Rush", "anchorage_rush.png", "#D4AF37", "#4682B4"),
            new Team("Charleston", "Harbors", "charleston_harbors.png", "#4682B4", "#708090"),
            new Team("Flint", "Cores", "flint_cores.png", "#696969", "#FF4500"),
            new Team("Dodge City", "Lawmen", "dodgecity_lawmen.png", "#A0522D", "#F5F5DC"),
            new Team("Tampa", "Scallywags", "tampa_scallywags.png", "#800000", "#FFD700"),
            new Team("Gary", "Foundry", "gary_foundry.png", "#708090", "#8B0000"),
            new Team("Topeka", "Boarders", "topeka_boarders.png", "#2E8B57", "#D3D3D3"),
            new Team("El Paso", "Passers", "elpaso_passers.png", "#DAA520", "#CD853F"),
            new Team("Mobile", "Revelers", "mobile_revelers.png", "#800080", "#FFD700"),
            new Team("Madison", "Protesters", "madison_protesters.png", "#A9A9A9", "#006400"),
            new Team("Hartford", "Writers", "hartford_writers.png", "#00008B", "#D2B48C"),
            new Team("Richmond", "Ghosts", "richmond_ghosts.png", "#696969", "#778899"),
            new Team("Albuquerque", "Bombers", "abq_bombers.png", "#A52A2A", "#F0E68C"),
            new Team("Helena", "Prospectors", "helena_prospectors.png", "#DAA520", "#2F4F4F")
        );
    }
}
