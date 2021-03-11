package interviews;

public class CompassPilot implements AutoPilot {

    @Override
    public void control(Mower mower, Lawn lawn) {
        //        Read instructions and apply them to mower position while making sure we're always within the lawn

        ////            Instruction must be an enum of D G A
        ////            Direction is an enum too => has methods to change direction right or left should take a Command
        mower.getCommands().forEach(command -> perform(command, mower, lawn));
    }

    private void perform(Command command, Mower mower, Lawn lawn) {
        switch (command) {
            case D:
                Direction.turnRight(mower.getDirection());
                break;
            case G:
                Direction.turnLeft(mower.getDirection());
                break;
            case A:
                advance(mower, lawn);
                break;
            default:
                System.out.println("command = " + command + " is not supported yet!");
        }
    }

    private void advance(Mower mower, Lawn lawn) {
        // Check which direction we are facing and de/increment the mower's coordinate accordingly, don't forget to make sure we're not moving out of the lawn
        throw new UnsupportedOperationException();
    }
}
