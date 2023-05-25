import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Assignment_13904 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;
        int count = Integer.parseInt(br.readLine());

        int[][] assign = new int[count][2];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            assign[i][0] = Integer.parseInt(st.nextToken());
            assign[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println();
        Arrays.sort(assign, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < count; i++) {
            System.out.println(Arrays.toString(assign[i]));
        }

        int index = 0;
        int reverseDay = count;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (index < count) {
            int[] item = assign[index];
            int day = item[0];
            int score = item[1];

            queue.add(score);
            if (--reverseDay <= day) {
                // 거꾸로 가는 날짜가 마감날짜보다 같거나 작을경우
                int num = queue.poll();
                result += num;
            } else {
                // 날짜 하루 감소
                count--;
            }
            System.out.println(item[1]);

            index++;
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}