package codeeval.blackcard;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.Test;


public class BlackCardDemoTest {


   @Test
   public void should_rerturn_the_jhon() {
      ArrayList sevenPlayers = dummyPlayers(3);
      BlackCardDemo.go(5, sevenPlayers);
      assertThat(sevenPlayers.size()).isEqualTo(1);
      assertThat(sevenPlayers.get(0)).isEqualTo("Player3");
   }


   private ArrayList dummyPlayers(int numberOfPlayers) {
      ArrayList players = new ArrayList();
      for (int i = 1; i <= numberOfPlayers; i++) {
         players.add("Player" + i);
      }

      return players;
   }
}
