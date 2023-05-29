import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_Mul_1629 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        Long result = 0L;
        st = new StringTokenizer(br.readLine());

        Long num = Long.parseLong(st.nextToken());
        Long pow = Long.parseLong(st.nextToken());
        Long div = Long.parseLong(st.nextToken());

        result = extra(num, pow, div);

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static Long extra(Long num, Long pow, Long div) {
        Long result = 0L;
        if (pow == 1)
            return num % div;

        result = extra(num, pow / 2, div);
        if (pow % 2 != 0) {
            return ((result % div) * (result * num % div) % div);
        } else {
            return ((result % div) * (result % div) % div);
        }
    }
}