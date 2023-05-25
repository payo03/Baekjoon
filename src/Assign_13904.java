import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Assign_13904 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;
        int count = Integer.parseInt(br.readLine());

        int[][] assign = new int[count][2];
        int maxDay = 0;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            assign[i][0] = Integer.parseInt(st.nextToken());
            assign[i][1] = Integer.parseInt(st.nextToken());

            maxDay = Math.max(maxDay, assign[i][0]);
            list.add(new Integer[] { assign[i][0], assign[i][1] });
        }

        for (int i = maxDay; i > 0; i--) {

            Integer[] item = new Integer[2];
            int score = 0;

            // List중 'i'날짜보다 마감일이 늦거나 같은 item만
            for(int j=0; j<list.size(); j++) {
                Integer[] temp = list.get(j);
                // 가장 높은 점수를 받기위한 item select
                if(temp[0] >= i && score < temp[1]) {
                    item = temp;
                    score = temp[1];
                }
            }

            if(score != 0) {
                list.remove(item);
                result += item[1];
            }
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}