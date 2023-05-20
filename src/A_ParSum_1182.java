import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_ParSum_1182 {

    static int count;
    static int[] arr;
    static int size;
    static int target;

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (target == 0) count--;

        answer = count;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int sum, int depth) {

        if (depth == size) {
            if (sum == target)
                count++;
            return;
        }

        dfs(sum + arr[depth], depth + 1);
        dfs(sum, depth + 1);
    }

}