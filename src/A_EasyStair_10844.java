import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_EasyStair_10844 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        long result = 0;

        int num = Integer.parseInt(br.readLine());
        long[][] dp = new long[num + 1][10];
        long mod = 1000000000;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 2번째 자리수부터 탐색
        for (int i = 2; i <= num; i++) {

            // i번째 자릿수의 자릿값들을 탐색 (0~9)
            for (int j = 0; j < 10; j++) {

                if (j == 0) {           // j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
                    dp[i][0] = dp[i - 1][1] % mod;
                } else if (j == 9) {    // j=9라면 이전 자릿수는 8만 가능
                    dp[i][9] = dp[i - 1][8] % mod;
                } else {                // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}