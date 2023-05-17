import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class SevenDwarf_2309 {

    static int[] rDwarfList;
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // ========================================================================
        int size = 9;
        String answer = "";
        boolean[] check = new boolean[size];

        int[] dwarfList = new int[size];
        rDwarfList = new int[size - 2];
        for (int i = 0; i < size; i++) {
            dwarfList[i] = Integer.parseInt(br.readLine());
        }

        dfs(dwarfList, check, 0, 0);

        Arrays.sort(rDwarfList);
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<rDwarfList.length; i++) {
            sb.append(rDwarfList[i] + "\n");
        }

        answer = sb.toString();
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int[] dwarfList, boolean[] check, int heightSum, int depth) {
        if (depth == 7 && heightSum == 100) {
            int index = 0;
            for(int i=0; i<check.length; i++) {
                if(check[i]) rDwarfList[index++] = dwarfList[i];
            }
            return;
        }

        for (int i = 0; i < dwarfList.length; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(dwarfList, check, heightSum + dwarfList[i], depth + 1);
                check[i] = false;
            }
        }

    }
}