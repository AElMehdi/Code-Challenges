package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] baseArray = new int[n];

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];
            for (int i = a; i < b; i++) {
                baseArray[i] += k;
            }
        }

        for (int i : baseArray) {
            System.out.println(baseArray[i]);
        }

        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nm = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nm[0]);
//
//        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};

//        for (int i = 0; i < m; i++) {
//            String[] queriesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 3; j++) {
//                int queriesItem = Integer.parseInt(queriesRowItems[j]);
//                queries[i][j] = queriesItem;
//            }
//        }

        long result = arrayManipulation(5, queries);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
    }
}
