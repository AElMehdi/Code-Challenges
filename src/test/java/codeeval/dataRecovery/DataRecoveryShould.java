package codeeval.dataRecovery;

import static codeeval.dataRecovery.DataRecovery.recoverData;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataRecoveryShould {

   @DataProvider(name = "testCases")
   private Object[][] createTestData() {
      return new Object[][]{
            {"", ""},
            {null, ""},
            {"2000 and was not However, implemented 1998 it until;9 8 3 4 1 5 7 2",
                  "However, it was not implemented until 1998 and 2000"},
            {"programming first The language;3 2 1",
                  "The first programming language"},
            {"programs Manchester The written ran Mark 1952 1 in Autocode from;6 2 1 7 5 3 11 4 8 9",
                  "The Manchester Mark 1 ran programs written in Autocode from 1952"},
      };
   }

   @Test(dataProvider = "testCases")
   public void reconstruct_a_given_sentence_based_on_hints(String shuffledSentence, String expected) {
      assertThat(recoverData(shuffledSentence)).isEqualTo(expected);
   }
}