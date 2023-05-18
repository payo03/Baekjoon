import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class Candy_3085 {

    static int max;

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        int size = Integer.parseInt(br.readLine());
        char[][] candyMap = new char[size][size];

        for (int i = 0; i < size; i++) {
            String str = br.readLine();
            for (int j = 0; j < size; j++) {
                candyMap[i][j] = str.charAt(j);
            }
        }

        dfs(candyMap, "row");
        dfs(candyMap, "col");

        answer = max;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(char[][] candyMap, String dir) {
        int size = candyMap.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size; j++) {
                if ("row".equals(dir)) {
                    char candy = candyMap[i][j];
                    candyMap[i][j] = candyMap[i + 1][j];
                    candyMap[i + 1][j] = candy;

                    candyCheck(candyMap);

                    candyMap[i + 1][j] = candyMap[i][j];
                    candyMap[i][j] = candy;

                } else {
                    char candy = candyMap[j][i];
                    candyMap[j][i] = candyMap[j][i + 1];
                    candyMap[j][i + 1] = candy;

                    candyCheck(candyMap);

                    candyMap[j][i + 1] = candyMap[j][i];
                    candyMap[j][i] = candy;
                }

            }
        }
    }

    public static void candyCheck(char[][] candyMap) {
        int size = candyMap.length;

        System.out.println("##### SwapMap #####");
        for (int i = 0; i < size; i++) {
            int rSum = 1;
            int cSum = 1;
            for (int j = 0; j < size - 1; j++) {
                char rCandy = candyMap[i][j];
                char rSwapCandy = candyMap[i][j + 1];

                char cCandy = candyMap[j][i];
                char cSwapCandy = candyMap[j + 1][i];

                if (rCandy == rSwapCandy) {
                    rSum++;
                } else {
                    rSum = 1;
                }
                if (cCandy == cSwapCandy) {
                    cSum++;
                } else {
                    cSum = 1;
                }
                max = Math.max(max, Math.max(rSum, cSum));
            }

            for (int j = 0; j < size; j++) {
                System.out.print(candyMap[i][j] + " ");
            }
            System.out.println();
        }

    }
}