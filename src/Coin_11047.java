import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Coin_11047 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (target >= list.get(i)) {

                result += target / list.get(i);
                target %= list.get(i);
            }

            if(target == 0) break;
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}