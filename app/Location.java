package app;

import java.util.HashMap;
import java.util.Map;

public class Location {
  private final int locationID;
  private final String description;
  private final Map<String, Integer> exits;

  public Location(int locationID, String description, Map<String, Integer> exits) {
    this.locationID = locationID;
    this.description = description;
    if (exits == null) {
      this.exits = new HashMap<String, Integer>();
    } else {
      this.exits = new HashMap<String, Integer>(exits);
    }
  }

  public int getLocationID() {
    return this.locationID;
  }

  public String getDescription() {
    return this.description;
  }

  public Map<String, Integer> getExits() {
    return new HashMap<>(this.exits);
  }
}
