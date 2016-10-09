package codeeval.blackcard;

import static codeeval.blackcard.FileReaderUtils.getBlackSpot;
import static codeeval.blackcard.FileReaderUtils.getPlayers;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FileReaderUtilsTest {

   @Test
   public void should_return_black_card_from_a_valid_input() {
      // TODO Reimplement it using regex
      int blackSpot = getBlackSpot("Player1 Player2 Player3 Player4 | 7");

      assertThat(blackSpot).isEqualTo(7);
   }

   @Test
   public void should_return_minus_one_from_an_invalid_input() {
      int blackSpot = getBlackSpot("invalid input");

      assertThat(blackSpot).isEqualTo(-1);
   }

   @Test
   public void should_return_players_from_a_valid_input_keeping_the_order() {
      // TODO Reimplement it using regex
      List<String> players = getPlayers("Player1 Player2 Player3 Player4 | 7");

      ArrayList expectedPlayers = dummyPlayers(4);

      assertThat(players).isEqualTo(expectedPlayers);
   }

   private ArrayList dummyPlayers(int numberOfPlayers) {
      ArrayList players = new ArrayList();
      for (int i = 1; i <= numberOfPlayers; i++) {
         players.add("Player" + i);
      }

      return players;
   }
}
