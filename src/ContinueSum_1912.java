import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class ContinueSum_1912 {
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // ========================================================================
        int answer = 0;
        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[size];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }
        if (max < 0) answer = max;

        // for (int i = 0; i < size; i++) {
        //     int sum = arr[i];
        //     for (int j = i + 1; j < size; j++) {
        //         sum += arr[j];
        //         answer = Math.max(answer, sum);
        //     }
        // }

        int[] dp = new int[size];
        dp[0] = arr[0];
        for (int i = 1; i < size; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

            System.out.println(dp[i]);
            answer = Math.max(dp[i], answer);
        }

        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}