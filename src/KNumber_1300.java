import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class KNumber_1300 {
    public static void main(String[] args) throws Exception{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        // ========================================================================
        int answer = 0;

        int[] returnArr = new int[size*size];
        int index = 0;
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                returnArr[index++] = i*j;
            }
        }
        Arrays.sort(returnArr);
        answer = returnArr[target];

        // ========================================================================

        bw.write(String.valueOf(answer));
        
        bw.flush();
        bw.close();
        br.close();
    }
}