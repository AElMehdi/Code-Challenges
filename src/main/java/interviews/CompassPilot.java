package interviews;

import static interviews.Command.*;
import static interviews.Direction.*;

public class CompassPilot implements AutoPilot {

    @Override
    public void control(Mower mower, Lawn lawn) {
//        Read instructions and apply them to mower position while making sure we're always within the lawn

        ////            Instruction must be an enum of D G A
        ////            Direction is an enum too => has methods to change direction right or left should take an instruction
        mower.getCommands().forEach(command -> perform(command, mower));
        }

    private void perform(Command command, Mower mower) {
        if (command.equals(G)) {
            mower.setDirection(W);
        }
    }
}
