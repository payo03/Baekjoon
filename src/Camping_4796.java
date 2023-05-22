import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Camping_4796 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        List<String[]> list = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            String[] arr = line.split(" ");
            list.add(arr);

            if (arr[0].equals(arr[1]) && arr[1].equals(arr[2]) && "0".equals(arr[2]))
                break;
        }

        String result = "";
        for (int i = 0; i < list.size() - 1; i++) {
            int usingTerm = Integer.parseInt(list.get(i)[0]);
            int day = Integer.parseInt(list.get(i)[1]);
            int totalTerm = Integer.parseInt(list.get(i)[2]);

            int totalLength = (totalTerm / day * usingTerm) + Math.min(usingTerm, (totalTerm % day));

            result += "Case " + (i + 1) + ": " + totalLength + "\n";
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}