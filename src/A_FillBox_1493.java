import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_FillBox_1493 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        long result = 0;
        st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int size = Integer.parseInt(br.readLine());
        long[] box = new long[size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            long count = Integer.parseInt(st.nextToken());

            box[type] = count;
        }

        long prevFill = 0;
        for (int type = size - 1; type >= 0; type--) {

            int fillBox = (int) Math.pow(2, type);

            // 대상 박스를 채울 박스(2^i)의 width, length, height로 나눈 후, 채워진 면을 뺐을때 필요한 갯수
            long fillBoxCount = (long) (width / fillBox) * (length / fillBox) * (height / fillBox) - prevFill;
            // 채울 박스갯수와 비교
            long possiblebox = Math.min(box[type], fillBoxCount);

            prevFill += possiblebox; // 이전에 채운 BoxCount
            prevFill *= 8; // width, length, height이므로 prevFill * 8

            result += possiblebox;
        }

        if ((prevFill / 8) != (long) length * width * height) {
            result = -1;
        }

        answer = result;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}