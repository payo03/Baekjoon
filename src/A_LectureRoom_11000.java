import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_LectureRoom_11000 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;
        int size = Integer.parseInt(br.readLine());

        int[][] room = new int[size][2];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(room[0][1]);

        for (int i = 1; i < size; i++) {
            if (queue.peek() <= room[i][0]) {
                queue.poll();
            }
            queue.add(room[i][1]);
            System.out.println(queue);
        }
        answer = queue.size();
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}