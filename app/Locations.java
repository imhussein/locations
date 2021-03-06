package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
  private static Map<Integer, Location> locations = new HashMap<>();

  public static void main(String[] args) throws IOException {
    try (FileWriter locFile = new FileWriter("locations.txt"); FileWriter fileWriter = new FileWriter("exits.txt")) {
      for (Location location : locations.values()) {
        locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
        for (String exit : location.getExits().keySet()) {
          fileWriter.write(location.getLocationID() + "," + exit + "," + location.getExits().get(exit) + "\n");
        }
      }
    }
  }

  static {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new FileReader("locations.txt"));
      scanner.useDelimiter(",");
      while (scanner.hasNextLine()) {
        int loc = scanner.nextInt();
        scanner.skip(scanner.delimiter());
        String description = scanner.nextLine();
        System.out.println("Imported Loc " + loc + ":" + description);
        Map<String, Integer> tempExits = new HashMap<>();
        locations.put(loc, new Location(loc, description, tempExits));
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }
    // Map<String, Integer> tempExit = new HashMap<>();
    // locations.put(0, new Location(0, "You are setting in front of computer
    // learning java", null));
    // tempExit = new HashMap<String, Integer>();
    // tempExit.put("W", 2);
    // tempExit.put("E", 3);
    // tempExit.put("S", 4);
    // tempExit.put("N", 5);
    // locations.put(1, new Location(2, "your are setting at the end of the road",
    // tempExit));
    // tempExit = new HashMap<String, Integer>();
    // tempExit.put("N", 5);
    // locations.put(2, new Location(2, "your are at the top of a hill", tempExit));
    // tempExit = new HashMap<String, Integer>();
    // tempExit.put("W", 3);
    // locations.put(3, new Location(2, "you are inside a building", tempExit));
    // tempExit = new HashMap<String, Integer>();
    // tempExit.put("N", 1);
    // tempExit.put("W", 2);
    // locations.put(4, new Location(4, "your are in a valley", tempExit));
    // tempExit = new HashMap<String, Integer>();
    // tempExit.put("S", 1);
    // tempExit.put("W", 2);
    // locations.put(5, new Location(4, "you are in the forest", tempExit));
  }

  @Override
  public int size() {
    return locations.size();
  }

  @Override
  public boolean isEmpty() {
    return locations.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return locations.containsKey(key);
  }

  @Override
  public boolean containsValue(Object key) {
    return locations.containsValue(key);
  }

  @Override
  public Location get(Object key) {
    return locations.get(key);
  }

  @Override
  public Location put(Integer key, Location value) {
    return locations.put(key, value);
  }

  @Override
  public Location remove(Object key) {
    return locations.remove(key);
  }

  @Override
  public void putAll(Map<? extends Integer, ? extends Location> m) {

  }

  @Override
  public void clear() {
    locations.clear();
  }

  @Override
  public Set<Integer> keySet() {
    return locations.keySet();
  }

  @Override
  public Collection<Location> values() {
    return locations.values();
  }

  @Override
  public Set<Entry<Integer, Location>> entrySet() {
    return locations.entrySet();
  }
}
