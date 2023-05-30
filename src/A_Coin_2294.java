import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_Coin_2294 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        long result = 0;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coinList = new int[size];
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());

            coinList[i] = num;
        }

        int[] dp = new int[10001];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < size; i++) {
            for (int j = coinList[i]; j <= target; j++) {
                dp[j] = Math.min(dp[j], dp[j - coinList[i]] +1);

            }
        }

        result = dp[target] == 10001 ? -1 : dp[target];

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}