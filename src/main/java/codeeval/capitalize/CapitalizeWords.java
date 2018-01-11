package codeeval.capitalize;

import static java.lang.Character.toUpperCase;

class CapitalizeWords {

   static String capitalize(String sentence) {
      return isValid(sentence) ? apply(sentence) : "";
   }

   private static String apply(String sentence) {
      String[] words = toWords(sentence);
      StringBuilder capitalized = new StringBuilder(sentence.length());

      for (String word : words) {
         StringBuilder wordBuilder = new StringBuilder(word);

         capitalizeFirstChar(word, wordBuilder);

         capitalized.append(wordBuilder + " ");
      }

      return capitalized
            .toString()
            .trim();
   }

   private static void capitalizeFirstChar(String word, StringBuilder wordBuilder) {
      wordBuilder.delete(0, 1);
      wordBuilder.insert(0, toUpperCase(word.charAt(0)));
   }

   private static boolean isValid(String sentence) {
      return sentence != null && !sentence.isEmpty();
   }

   private static String[] toWords(String sentence) {
      return sentence
            .trim()
            .split(" ");
   }
}
