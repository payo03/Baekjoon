package newSolution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class BFS_B_2309 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = null;
        // ========================================================================
        int[] numArr = new int[9];

        int sum = -100;
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            numArr[i] = num;

            sum += num;
        }
        Arrays.sort(numArr);

        int dwarfIdx1 = 0;
        int dwarfIdx2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (numArr[i] + numArr[j] == sum) {
                    dwarfIdx1 = i;
                    dwarfIdx2 = j;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<9; i++) {
            if(dwarfIdx1 == i || dwarfIdx2 == i) continue;
            sb.append(numArr[i] + "\n");
        }
        answer = sb.toString();
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}