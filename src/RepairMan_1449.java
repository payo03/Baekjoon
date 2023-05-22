import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class RepairMan_1449 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        String firstL = br.readLine();
        String secondL = br.readLine();

        String[] firstArr = firstL.split(" ");
        String[] secondArr = secondL.split(" ");

        int breakCount = Integer.parseInt(firstArr[0]);
        int tapeLength = Integer.parseInt(firstArr[1]);

        Double[] arr = new Double[breakCount];
        for (int i = 0; i < breakCount; i++) {
            arr[i] = Double.parseDouble(secondArr[i]);
        }
        Arrays.sort(arr);

        int count = 0;
        Double tapeAttach = 0.0;
        for (int i = 0; i < breakCount; i++) {
            Double item = arr[i];

            Double startItem = item - 0.5;
            Double endItem = item + 0.5;

            if (tapeAttach < endItem) {
                tapeAttach = 0.0;
                tapeAttach += tapeLength + startItem;
                count++;
                System.out.println(startItem + " / " + endItem + " : " + tapeAttach);
            }
        }
        answer = count;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

}