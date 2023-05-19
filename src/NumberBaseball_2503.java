import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class NumberBaseball_2503 {
    
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        int size = Integer.parseInt(br.readLine());

        String[][] baseBall = new String[size][3];
        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            baseBall[i] = line.split(" ");
        }

        answer = game(baseBall, size);
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int game(String[][] baseBall, int size) {
        int result = 0;
        for (int i = 123; i <= 987; i++) {
            String idx = String.valueOf(i);

            if (check(idx)) {
                int test = 0;
                for (int j = 0; j < size; j++) {
                    String myBall = idx;

                    String ball = baseBall[j][0];
                    int sCount = Integer.parseInt(baseBall[j][1]);
                    int bCount = Integer.parseInt(baseBall[j][2]);

                    int csCount = 0;
                    for (int k = 0; k < 3; k++) {

                        if (myBall.charAt(k) == ball.charAt(k))
                            csCount++;
                    }

                    int cbCount = 0;
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {

                            if (k != h) {
                                if (myBall.charAt(k) == ball.charAt(h)) cbCount++;
                            }
                        }
                    }

                    if (csCount == sCount && cbCount == bCount) {
                        test++;
                    }
                }
                if (test == size) 
                    result++;
            }

        }

        return result;
    }

    private static boolean check(String idx) {
        char first = idx.charAt(0);
        char second = idx.charAt(1);
        char last = idx.charAt(2);

        if (first == second || first == last || second == last)
            return false;
        if (first == '0' || second == '0' || last == '0')
            return false;

        return true;
    }
}