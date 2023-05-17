import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class XLowNumber_10871 {
    public static void main(String[] args) throws Exception{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        // ========================================================================
        String answer = "";

        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num < target) answer += String.valueOf(num) + " ";
        }

        // ========================================================================
        bw.write(answer);
        
        bw.flush();
        bw.close();
        br.close();
    }
}