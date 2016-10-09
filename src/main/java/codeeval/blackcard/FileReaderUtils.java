package codeeval.blackcard;

import static java.util.Arrays.asList;

import java.util.List;

public class FileReaderUtils {

   public static int getBlackSpot(String testCase) {
      String[] playersAndBlackSpot = testCase.split("\\|");

      if (isAValidInput(playersAndBlackSpot)) {
         String blackSpot = playersAndBlackSpot[1].trim();
         return Integer.parseInt(blackSpot);
      }

      // TODO Better use exceptions!
      return -1;
   }

   public static List<String> getPlayers(String testCase) {
      List<String> splitLine = asList(testCase.split(" ", 7));
      return splitLine.subList(0, splitLine.size() - 2);
   }

   private static boolean isAValidInput(String[] playersAndBlackCard) {
      return (playersAndBlackCard.length == 2) ? true : false;
   }
}
