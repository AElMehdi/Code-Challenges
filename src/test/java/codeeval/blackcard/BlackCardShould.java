package codeeval.blackcard;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class BlackCardShould {

   @Test
   public void testName() {
      assertThat(BlackCard.play("John Sara Tom Susan | 3"))
            .isEqualTo("Sara");
   }
}