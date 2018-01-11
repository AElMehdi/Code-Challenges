package codeeval.capitalize;

import static codeeval.capitalize.CapitalizeWords.capitalize;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CapitalizeWordsShould {

   @DataProvider(name = "testCases")
   private Object[][] createData() {
      return new Object[][]{
            {null, ""},
            {"", ""},
            {"Hello world", "Hello World"},
            {"javaScript language", "JavaScript Language"},
            {"a letter", "A Letter"},
            {"1st thing", "1st Thing"}
      };
   }

   @Test(dataProvider = "testCases")
   public void capitalize_first_letter_of_each_word_in_a_sentence(String sentence, String expected) {
      assertThat(capitalize(sentence)).isEqualTo(expected);
   }
}
