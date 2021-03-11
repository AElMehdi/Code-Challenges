package interviews.mower.autoPilot;

import interviews.mower.Mower;

public class CardinalDirectionPilot implements AutoPilot {

    @Override
    public void move(Mower mower) {
        mower.getInstructions()
                .forEach(command -> command.executeOn(mower));
    }
}
