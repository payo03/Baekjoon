import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class TwoMulNTiling_11726 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        long result = 0;
        long mod = 10007;
        int num = Integer.parseInt(br.readLine());

        long[] dp = new long[num + 1];

        if(num == 1) {
            bw.write("1");

            bw.flush();
            bw.close();
            br.close();

            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = (dp[i - 1] % mod) + (dp[i - 2] % mod);
        }
        result = dp[num] % mod;

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}