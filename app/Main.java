package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  private static Locations locations = new Locations();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Map<String, String> vocabulary = new HashMap<>();
    vocabulary.put("QUIT", "C");
    vocabulary.put("NORTH", "N");
    vocabulary.put("SOUTH", "S");
    vocabulary.put("WEST", "W");
    vocabulary.put("EAST", "E");
    int loc = 1;
    while (true) {
      System.out.println(locations.get(loc).getDescription());
      if (loc == 0) {
        break;
      }
      Map<String, Integer> exits = locations.get(loc).getExits();
      System.out.println("Available Exists are ");
      for (String exit : exits.keySet()) {
        System.out.print(exit + " ,");
      }
      System.out.println();
      String direction = scanner.nextLine().toUpperCase();
      if (direction.length() > 1) {
        String[] words = direction.split(" ");
        for (String word : words) {
          if (vocabulary.containsKey(word)) {
            direction = vocabulary.get(word);
            break;
          }
        }
      }
      if (exits.containsKey(direction)) {
        loc = exits.get(direction);
      }
    }
  }
}