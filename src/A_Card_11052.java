import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_Card_11052 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        long result = 0;

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] cardAmount = new int[num];
        for (int i = 0; i < num; i++) {
            cardAmount[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + cardAmount[j - 1]);
            }
        }
        result = dp[num];

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}