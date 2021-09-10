package euler;


/*
 *  Multiples of 3 or 5
 *  https://projecteuler.net/problem=1
 * */

public class Problem1 {

    /*
    * This is a 0(N) algorithm as a straightforward solution
    * */
    public static int process(int upperLimit) {
        int sum = 0;

        for (int i = 0; i < upperLimit; i++) {
            if (isMultipleOf(i, 3) || isMultipleOf(i, 5)) {
                sum += i;
            }
        }

        return sum;
    }

    private static boolean isMultipleOf(int i, int checkAgainst) {
        return i % checkAgainst == 0;
    }
}
