package codeeval.cleanupWords;

class CleanUpWords {

   private static final String ALPHA_MATCHER = "[^\\p{Alpha}]";
   private static final String WHITESPACE_MATCHER = "\\s+";

   static String cleanUpWord(String word) {
      return isNullOrEmpty(word) ? "" : removeExtraSymbols(word);
   }

   private static String removeExtraSymbols(String word) {
      String replaceNonAlphaWithSpaces = word.replaceAll(ALPHA_MATCHER, " ")
            .trim();
      return replaceNonAlphaWithSpaces.replaceAll(WHITESPACE_MATCHER, " ")
            .toLowerCase();
   }

   private static boolean isNullOrEmpty(String word) {
      return word  == null || word.isEmpty();
   }
}
