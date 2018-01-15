package codeeval.cleanupWords;

import static codeeval.cleanupWords.CleanUpWords.cleanUpWord;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CleanUpWordsShould {

   @Test
   public void clean_up_numbers_and_special_characters() {
      String cleanedWord = cleanUpWord("(--9Hello----World...--)");

      assertThat(cleanedWord).isEqualTo("hello world");
   }
}