package interviews;

import java.util.List;

public class MowItNowApp {

    public static void main(String[] args) {
        // Read from file, parse, and validate (entered values + business validation (Are the position within the lawn range)
        // If all is well, I'll be having =>
        //  topRightCorner (Lawn Size) Needed for calculation
        //  Mower Init Coordinate + Array of instructions? (How to call this object?)
        //
        //  Mower Object will have a position(x,y), navigator, instructions


        //        InitFromFile(path) => List<Mower>
    }

    public List<Mower> run(Lawn lawn, List<Mower> mowers) {
        mowers.forEach(mower -> mower.start());
        return mowers;
    }
}
