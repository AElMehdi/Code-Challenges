package codeeval.cleanupWords;

public class CleanUpWords {

   public static String cleanUpWord(String word) {
      String replaceNonAlphaWithSpaces = word.replaceAll("[^\\p{Alpha}]", " ");
      String trimmed = replaceNonAlphaWithSpaces.trim();
      String alors = trimmed.replaceAll("\\p{Alpha}+\\p{Space}*\\p{Alpha}", " ");
      return trimmed;
   }
}
