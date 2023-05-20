import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class Chess_1018 {

    static int row;
    static int col;

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer = 0;
        // ========================================================================
        String readLine = br.readLine();
        String[] size = readLine.split(" ");

        row = Integer.parseInt(size[0]);
        col = Integer.parseInt(size[1]);

        char[][] map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();

            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int min = 32;
        for (int startR = 0; startR <= row - 8; startR++) {
            for (int startC = 0; startC <= col - 8; startC++) {
                min = Math.min(min, findMin(map, startR, startC));
            }
        }

        answer = min;
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int findMin(char[][] map, int row, int col) {
        int count = 0;
        char currentColor = map[row][col]; // 초기화
        for (int i = row; i < row + 8; i++) {
            char prevColor = currentColor; // 이전 색깔
            currentColor = map[i][col];
            if (i > row && prevColor == currentColor) { // 각 row의 시작 Color 비교
                if (currentColor == 'B')
                    currentColor = 'W';
                else
                    currentColor = 'B';
                count++;
            }

            int cVar = currentColor;
            for (int j = col + 1; j < col + 8; j++) {
                if (cVar == map[i][j]) {
                    if (cVar == 'B')
                        cVar = 'W';
                    else
                        cVar = 'B';
                    count++;
                } else {
                    cVar = map[i][j];
                }
            }
        }

        // 왼쪽 꼭지점 변경했을때의 Case
        if (map[row][col] == 'B')
            map[row][col] = 'W';
        else
            map[row][col] = 'B';

        int reverseCount = 1;
        currentColor = map[row][col]; // 초기화
        for (int i = row; i < row + 8; i++) {
            char prevColor = currentColor; // 이전 색깔
            currentColor = map[i][col];
            if (i > row && prevColor == currentColor) { // 각 row의 시작 Color 비교
                if (currentColor == 'B')
                    currentColor = 'W';
                else
                    currentColor = 'B';
                reverseCount++;
            }

            int cVar = currentColor;
            for (int j = col + 1; j < col + 8; j++) {
                if (cVar == map[i][j]) {
                    if (cVar == 'B')
                        cVar = 'W';
                    else
                        cVar = 'B';
                    reverseCount++;
                } else {
                    cVar = map[i][j];
                }
            }
        }

        return Math.min(count, reverseCount);
    }

}