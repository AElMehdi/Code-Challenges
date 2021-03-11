package interviews;

public class CardinalDirectionAutoPilot implements AutoPilot {

    private Lawn lawn;

    public CardinalDirectionAutoPilot(Lawn lawn) {
        this.lawn = lawn;
    }

    @Override
    public void control(Mower mower, Lawn lawn) {
    }
}
