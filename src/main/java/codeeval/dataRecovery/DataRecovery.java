package codeeval.dataRecovery;

import static java.lang.Integer.parseInt;
import static java.lang.String.join;

class DataRecovery {

   private static final int SENTENCE_INDEX = 0;
   private static final int HINTS_INDEX = 1;
   private static final String SPACE_DELIMITER = " ";
   private static final String COMMA_DELIMITER = ";";

   static String recoverData(String input) {
      return isNullOrEmpty(input) ? "" : reconstructFromHints(input);
   }

   private static String reconstructFromHints(String input) {
      String[] shuffledSentenceAndHints = input.split(COMMA_DELIMITER);
      String[] shuffledWords = decompose(shuffledSentenceAndHints[SENTENCE_INDEX]);
      String[] hints = decompose(shuffledSentenceAndHints[HINTS_INDEX]);

      return useHints(shuffledWords, hints);
   }

   private static String useHints(String[] shuffledWords, String[] hints) {
      String almostReconstructed = placeAllExceptLastWord(shuffledWords, hints);

      return placeTheLastWord(shuffledWords, almostReconstructed);
   }

   private static String placeAllExceptLastWord(String[] shuffledWords, String[] hints) {
      String[] almostReconstructed = new String[shuffledWords.length];

      for (int i = 0; i < hints.length; i++) {
         int indexWhereToPutTheWord = parseInt(hints[i]) - 1;
         almostReconstructed[indexWhereToPutTheWord] = shuffledWords[i];
      }

      return join(SPACE_DELIMITER, almostReconstructed);
   }

   private static String placeTheLastWord(String[] shuffledWords, String almostReconstructed) {
      int lastWordIndex = shuffledWords.length - 1;
      return almostReconstructed.replace("null", shuffledWords[lastWordIndex]);
   }

   private static String[] decompose(String input) {
      return input.split(SPACE_DELIMITER);
   }

   private static boolean isNullOrEmpty(String input) {
      return input == null || input.isEmpty();
   }
}