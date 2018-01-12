package codeeval.racingChars;

import static codeeval.racingChars.RacingChars.getInTrack;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RacingCharsShould {

   @DataProvider(name = "createTrack")
   private static Object[][] createTrack() {
      return new Object[][]{
            {null, null},
            {"", ""},
            {"#########_##", "#########|##"},
            {"########C_##", "########/_##"},
            {"#######_####", "#######/####"},
            {"######_#C###", "######_#\\###"},
            {"######_C####", "######_/####"},
            {"######_#####", "######/#####"},
            {"#####C#_####", "#####/#_####"},
            {"#####C_#####", "#####|_#####"},
            {"######_#####", "######\\#####"},
            {"######_#####", "######|#####"}
      };

   }

   @Test(dataProvider = "createTrack")
   public void drive_through_the_whole_track(String track, String expected) {
      assertThat(getInTrack(track)).isEqualTo(expected);
   }
}