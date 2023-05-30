import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Sticker_9465 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        String result = "";
        int line = Integer.parseInt(br.readLine());

        for (int i = 0; i < line; i++) {
            int col = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][col + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= col; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            result += findMax(sticker) + "\n";
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static String findMax(int[][] sticker) {
        int result = 0;

        int[][] dp = sticker;
        int length = sticker[0].length;

        for (int j = 2; j < length; j++) {
            dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
            dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
        }

        System.out.print(Arrays.toString(dp[0]) + " ");
        System.out.println();
        System.out.print(Arrays.toString(dp[1]) + " ");
        System.out.println();

        result = Math.max(dp[0][length - 1], dp[1][length - 1]);
        return String.valueOf(result);
    }

}