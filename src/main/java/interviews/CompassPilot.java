package interviews;

public class CompassPilot implements AutoPilot {

    @Override
    public void control(Mower mower, Lawn lawn) {
//        Read instructions and apply them to mower position while making sure we're always within the lawn
        char[] instructions = mower.getInstructions();

        for (int i = 0; i < instructions.length; i++) {
            char instruction = instructions[i];
            if (instruction == 'G') {
                mower.setDirection("W");
            }
        }
    }
}
