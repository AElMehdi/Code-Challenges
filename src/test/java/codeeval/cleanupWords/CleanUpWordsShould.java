package codeeval.cleanupWords;

import static codeeval.cleanupWords.CleanUpWords.cleanUpWord;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CleanUpWordsShould {

   @DataProvider(name = "testCases")
   private Object[][] createData() {
      return new Object[][]{
            {"", ""},
            {null, ""},
            {"(--9Hello----World...--)", "hello world"},
            {"Can 0$9 ---you~", "can you"},
            {"13What213are;11you-123+138doing7", "what are you doing"}
      };
   }

   @Test(dataProvider = "testCases")
   public void clean_up_numbers_and_special_characters(String sentence, String expected) {
      assertThat(cleanUpWord(sentence)).isEqualTo(expected);
   }
}