package newSolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class BFS_B_1912 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = null;
        // ========================================================================
        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[size];
        int[] dp = new int[size];
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());

            numArr[i] = num;
        }

        dp[0] = numArr[0];
        int max = numArr[0];
        for(int i=1; i<size; i++) {
            dp[i] = Math.max(dp[i-1] + numArr[i], numArr[i]);

            max = Math.max(dp[i], max);
        }
        answer = max;

        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}