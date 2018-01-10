package codeeval.blackcard;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

import java.util.List;

public class BlackCardValidator {


   /*
    * /* fer
    */
   public static int getBlackSpot(String testCase) {
      String[] playersAndBlackSpot = parseEntry(testCase);

      if (isAValidInput(playersAndBlackSpot)) {
         String blackSpot = playersAndBlackSpot[1].trim();
         return parseInt(blackSpot);
      }

      // TODO Better use exceptions!
      return -1;
   }

   public static List<String> getPlayers(String testCase) {
      List<String> splitLine = asList(testCase.split(" ", 10));
      return splitLine.subList(0, splitLine.size() - 2);
   }

   private static boolean isAValidInput(String[] playersAndBlackCard) {
      return (playersAndBlackCard.length == 2) ? true : false;
   }

   private static String[] parseEntry(String entry) {
      String[] playersAndBlackSpot = entry.split("\\|");
      return playersAndBlackSpot;
   }

   static boolean validateEntry(String entry) {
      return (parseEntry(entry).length == 2) ? true : false;
   }
}
