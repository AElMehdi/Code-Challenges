package codeeval.blackcard;

import static codeeval.blackcard.BlackCardValidator.getBlackSpot;
import static codeeval.blackcard.BlackCardValidator.getPlayers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlackCardDemo {
   private static List<String> results = new ArrayList<>();

   public static void main(String[] args) throws IOException {
      ClassLoader classLoader = BlackCardDemo.class.getClassLoader();
      File file = new File(classLoader.getResource("blackCard.txt").getFile());
      BufferedReader buffer = new BufferedReader(new FileReader(file));
      String line;
      while ((line = buffer.readLine()) != null) {
         line.trim();
         int blackSpot = getBlackSpot(line);
         List<String> players = getPlayers(line);
         results.add(go(blackSpot, players));
      }

      System.out.println(results);
   }

   static String go(int blackSpot, List<String> players) {
      while (players.size() >= blackSpot) {
         players.remove(blackSpot - 1);
      }

      while (players.size() > 1) {
         int blackSpottedPlayer = blackSpot % players.size();
         players.remove(blackSpottedPlayer - 1);
      }

      return players.get(0);
   }
}
