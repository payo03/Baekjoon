package newSolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class BFS_B_3085 {

    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = null;
        // ========================================================================
        int size = Integer.parseInt(br.readLine());

        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        bfs(map, 0);
        bfs(map, 1);

        answer = max;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(char[][] map, int check) {

        if (check == 0) {
            // col swap
            for (int i = 0; i < map.length; i++) {
                for (int j = 1; j < map.length; j++) {
                    char candy = map[i][j - 1];
                    map[i][j - 1] = map[i][j];
                    map[i][j] = candy;

                    if (map[i][j - 1] != map[i][j]) {
                        checkMap(map);
                    }

                    map[i][j] = map[i][j - 1];
                    map[i][j - 1] = candy;
                }
            }

        } else {
            // row swap
            for (int i = 0; i < map.length; i++) {
                for (int j = 1; j < map.length; j++) {
                    char candy = map[j - 1][i];
                    map[j - 1][i] = map[j][i];
                    map[j][i] = candy;

                    if (map[j - 1][i] != map[j][i]) {
                        checkMap(map);
                    }

                    map[j][i] = map[j - 1][i];
                    map[j - 1][i] = candy;
                }
            }
        }
    }

    private static void checkMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            int rSum = 1;
            int cSum = 1;
            for (int j = 0; j < map[i].length - 1; j++) {
                char rCandy = map[i][j];
                char rSwapCandy = map[i][j + 1];

                char cCandy = map[j][i];
                char cSwapCandy = map[j + 1][i];

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
        }
    }

}