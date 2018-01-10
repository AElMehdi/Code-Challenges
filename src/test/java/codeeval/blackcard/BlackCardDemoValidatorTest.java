package codeeval.blackcard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BlackCardDemoValidatorTest {
   @Test
   public void should_return_true_when_given_a_valid_entry() {
      assertThat(BlackCardValidator.validateEntry("Player1 Player2 Player3 Player4 | 7")).isTrue();
   }
}
