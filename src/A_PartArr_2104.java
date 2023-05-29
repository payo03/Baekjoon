import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public final class A_PartArr_2104 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Object answer;
        // ========================================================================
        int size = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        long[] arr = new long[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(st.nextToken());

            list.add(num);
            arr[i] = num;
        }

        int leftNum = leftPart(list, list.size());
        int rightNum = rightPart(list, 0);

        answer = divideAndConquer(arr, 0, size);
        // ========================================================================
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    private static int leftPart(List<Integer> list, int depth) {
        if (depth == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < depth; i++) {
            min = Math.min(min, list.get(i));

            sum += list.get(i);
        }
        int ans = sum * min;
        ans = Math.max(leftPart(list, depth - 1), ans);

        return ans;
    }

    private static int rightPart(List<Integer> list, int depth) {
        if (depth == list.size())
            return 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = depth; i < list.size(); i++) {
            min = Math.min(min, list.get(i));

            sum += list.get(i);
        }
        int ans = sum * min;
        ans = Math.max(rightPart(list, depth + 1), ans);

        return ans;
    }

    public static long divideAndConquer(long[] arr, int start, int end) {

        // start 와 end 가 동일하다면, 문제의 조건에 따른 반환값을 리턴한다.
        if (start == end) {
            return arr[start] * arr[start];
        }

        // 중간 인덱스
        int mid = (start + end) / 2;

        // 최대한 분할 할 수 있는 만큼 분할한다.
        // 분할된 값에서 가장 맥스인 값을 부분배열의 값으로 선정한다.
        long result = Math.max(divideAndConquer(arr, start, mid), divideAndConquer(arr, mid + 1, end));

        // 왼쪽분할과 오른쪽 분할에 걸치는 부분들을 합친다.
        int left = mid;
        int right = mid;
        long standardValue = arr[mid];
        long sum = arr[mid];

        // 중간부터 시작해서, 둘 값의 차이가 (end - start) 만큼 벌어지기 전까지 계속 중간 부분 처리를 수행해나간다.
        while (right - left <= end - start) {

            /**
             * 기준 값을 중심으로 left 가 start 의 위치로부터 어느정도까지 도달하였는지를 파악한다.
             * (1) 기준 값(중심 값) 에서 왼쪽으로 치우진 값 중 무엇이 더 작은지 판단한다. (부분배열에서 낮은 값을 선택해야 하기 때문에)
             * (2) 왼쪽으로 치우치게 되서 start 보다 값이 작아진다면 leftValue 는 -1 의 값을 가진다.
             * (3) -1의 값을 가진다는 의미는 start 범위를 벗어낫기 때문에 인덱스를 start 로 갱신한다.
             */
            long leftMinAreaValue = (left > start) ? Math.min(standardValue, arr[left - 1]) : -1;
            int leftIndex = (leftMinAreaValue == -1) ? 0 : left - 1;/** 인덱스를 초과하지 않는 아무런 수가 들어가도 상관 없음 **/
                    

            /**
             * left 와 동일한 로직으로 진행된다.
             */
            long rightMinAreaValue = (right < end) ? Math.min(standardValue, arr[right + 1]) : -1;
            int rightIndex = (rightMinAreaValue == -1) ? 0 : right + 1;/** 인덱스를 초과하지 않는 아무런 수가 들어가도 상관 없음 **/
                    

            /** 인덱스를 초과한다면 반대쪽 인덱스를 늘려나감, 따라서 한쪽의 값은 -1 로 설정된다. **/
            long partialLeftValue = (sum + arr[leftIndex]) * leftMinAreaValue;
            long partialRightValue = (sum + arr[rightIndex]) * rightMinAreaValue;

            if (partialLeftValue > partialRightValue) {
                // 왼쪽의 부분배열 값이 더 크다.
                standardValue = leftMinAreaValue;
                sum += arr[leftIndex];
                left -= 1;
            } else {
                // 오른쪽의 부분배열 값이 더 크다.
                standardValue = rightMinAreaValue;
                sum += arr[rightIndex];
                right += 1;
            }

            result = Math.max(result, standardValue * sum);
        }

        return result;
    }
}