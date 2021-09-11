package euler;


/*
 *  Even Fibonacci numbers
 *  https://projecteuler.net/problem=2
 * */

public class Problem2 {

    /*
     * O(N) algorithm with a naive solution
     * */

    //TODO: Solve it using Streams and Lambda
    public static int process() {
        int n;
        int nMinus2 = 1;
        int nMinus1 = 2;

        int result = 0;

        while (result < 4000000) {
            if (nMinus1 % 2 == 0) {
                result += nMinus1;
            }

            n = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = n;
        }

        return result;
    }

}
