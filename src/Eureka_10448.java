import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class Eureka_10448 {

    static int length;
    static int[] checkList;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        list = new ArrayList<>();
        int num = 1;
        int index = 1;
        while (max > num) {
            num = index * (index + 1) / 2;
            list.add(num);
            index++;
        }

        checkList = new int[length];
        for (int i = 0; i < length; i++) {
            permutation(0, arr[i], 0, i);
        }

        for (int i = 0; i < length; i++) {
            bw.write(String.valueOf(checkList[i] + "\n"));
        }
        // ========================================================================
        // bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static void permutation(int sum, int target, int cnt, int index) {
        if (cnt > 3 || checkList[index] == 1)
            return;
        if (cnt == 3) {
            if (sum == target)
                checkList[index] = 1;
            else
                checkList[index] = 0;
        }

        for (int i = 0; i < list.size(); i++) {
            permutation(sum + list.get(i), target, cnt + 1, index);
        }
    }
}