import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public final class DivideSum_2231 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        int num = Integer.parseInt(br.readLine());

        int size = String.valueOf(num).length();
        int start = num - 9 * size;

        int sum = 0;
        for (int i = start; i < num; i++) {

            sum = i;
            int checkSize = String.valueOf(i).length();
            for (int j = 0; j < checkSize; j++) {
                int divNum = String.valueOf(i).charAt(j) - '0';
                sum += divNum;
            }

            // 구글링 답
            // int number = i;
            // while (number != 0) {
            //     sum += number % 10;
            //     number /= 10;
            // }

            if (sum == num) {
                answer = i;
                break;
            }
        }

        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}