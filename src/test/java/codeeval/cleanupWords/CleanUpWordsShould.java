package codeeval.cleanupWords;

import static codeeval.cleanupWords.CleanUpWords.cleanUpWord;

import org.testng.annotations.Test;

public class CleanUpWordsShould {

   @Test
   public void clean_up_numbers_and_special_characters() {
      System.out.println(cleanUpWord("(--9Hello----World...--)"));
      System.out.println(cleanUpWord("Can 0$9 ---you~"));
      System.out.println(cleanUpWord("13What213are;11you-123+138doing7"));

//      assertThat(cleanedWord).isEqualTo("hello world");
   }
}