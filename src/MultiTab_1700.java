import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class MultiTab_1700 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int allCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] order = new int[allCount];
        boolean[] use = new boolean[allCount];
        for (int i = 0; i < allCount; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 0; i < allCount; i++) {
            int item = order[i];

            if (!use[item]) {
                if (maxCount < num) {
                    use[item] = true;
                    maxCount++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    for (int j = i; j < num; j++) {
                        // 꽂혀있는 콘센트 list
                        if (use[order[j]] && !list.contains(order[j])) {
                            list.add(order[j]);
                        }
                    }

                    if(list.size() != num) {
                         
                    } else {
                        int remove = list.get(list.size() - 1);
                        use[remove] = false;
                    }
                    use[item] = true;
                    result++;
                }
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