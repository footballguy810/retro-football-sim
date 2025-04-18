package env;

public class Stadium {
    private String name;
    private int capacity;
    private String city;
    private String climate;
    private int homeFieldAdvantage; // 1–100 scale
    private boolean retractableRoof;

    public Stadium(String name, int capacity, String city, String climate, int homeFieldAdvantage, boolean retractableRoof) {
        this.name = name;
        this.capacity = capacity;
        this.city = city;
        this.climate = climate;
        this.homeFieldAdvantage = homeFieldAdvantage;
        this.retractableRoof = retractableRoof;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getCity() { return city; }
    public String getClimate() { return climate; }
    public int getHomeFieldAdvantage() { return homeFieldAdvantage; }
    public boolean hasRetractableRoof() { return retractableRoof; }

    public String getSummary() {
        return name + " in " + city + " | Capacity: " + capacity + " | Climate: " + climate + 
               " | Home Field Advantage: " + homeFieldAdvantage + 
               (retractableRoof ? " | Roof: Retractable" : " | Roof: Fixed");
    }
}
