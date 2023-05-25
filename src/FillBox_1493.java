import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class FillBox_1493 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;
        st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int volumn = length * width * height;

        int size = Integer.parseInt(br.readLine());
        int[][] box = new int[size][2];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            box[i][0] = (int) (Math.pow(2, type) * Math.pow(2, type) * Math.pow(2, type));
            box[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = size - 1; i >= 0; i--) {

            int boxVolumn = box[i][0];
            int boxCount = box[i][1];

            int availableCount = volumn / boxVolumn;
            if (boxCount < availableCount) {
                volumn -= boxVolumn * boxCount;
                result += boxCount;
            } else {
                volumn -= boxVolumn * availableCount;
                result += availableCount;
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