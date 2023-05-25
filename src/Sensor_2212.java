import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Sensor_2212 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int result = 0;

        int sensorCount = Integer.parseInt(br.readLine());
        int concentration = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] coordinate = new int[sensorCount];
        for (int i = 0; i < sensorCount; i++) {
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate);
        Integer[] subArr = new Integer[sensorCount - 1];
        for (int i = 0; i < subArr.length; i++) {
            subArr[i] = coordinate[i + 1] - coordinate[i];
        }

        Arrays.sort(subArr);
        int length = subArr.length - (concentration + 1); 
        // (기지국의 수 - 1) 만큼 센서를 건너띌 수 있다.
        // ex, 기지국 2개 > 1번 건너띌수 있음

        // H : 기지국, A : 센서, 1 ~ 9 : 위치
        //
        //    H                      H
        // ---------           -------------
        //                     A
        // A       A           A   A       A
        // 1   2   3   4   5   6   7   8   9

        for (int i = 0; i < length; i++) {
            result += subArr[i];
        }

        answer = result;
        if (concentration > sensorCount)
            answer = 0;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}