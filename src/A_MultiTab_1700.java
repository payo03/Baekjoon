import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_MultiTab_1700 {

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
        int[] order = new int[allCount + 1];
        boolean[] use = new boolean[allCount + 1];
        for (int i = 0; i < allCount; i++) {
            order[i + 1] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 1; i <= allCount; i++) {
            int item = order[i];

            if (!use[item]) {
                if (maxCount < num) {
                    use[item] = true;
                    maxCount++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    int[] countList = new int[allCount + 1];
                    // 꽂혀있는 콘센트중 뒤에 꽂혀있는 콘센트 List
                    for (int j = i; j < order.length; j++) {
                        if (use[order[j]] && !list.contains(order[j])) {
                            list.add(order[j]);
                        }
                    }
                    
                    if (list.size() != num) {
                        for (int j = 1; j < use.length; j++) {
                            // 콘센트 꽂혀있으면서, 뒤에 없는 콘센트를 제거
                            if (use[j] && !list.contains(j)) {
                                use[j] = false;
                                System.out.print("# IF\n" + j + " 콘센트 제거, ");
                                break;
                            }
                        }
                    } else {
                        // 꽂혀있는 콘센트중 뒤에 꽂힐 콘센트가, 꽂을수있는 갯수와 같으면 가장 마지막에 Insert된 콘센트 제거
                        int remove = list.get(list.size() - 1);
                        use[remove] = false;
                        System.out.print("# ELSE\n" + remove + " 콘센트 제거, ");
                    }
                    System.out.println(item + " 추가");
                    use[item] = true;
                    result++;
                }
            }
            System.out.println(Arrays.toString(use));
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}