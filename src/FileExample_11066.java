import java.io.*;
import java.util.*;

public class FileExample_11066 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] sum;										//각 장들의 합을 담을 배열
		int[][] page;									//각 장을 담을 2차원 배열
		int[][] dp = new int[502][502];					//결과를 담을 2차원 배열
		
		int input = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=input; i++) {
			int size = Integer.parseInt(br.readLine());
			sum = new int[size+1];
			page = new int[input+1][size+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=size; j++) {
				//각 page들의 크기
				page[i][j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + page[i][j];			//sum에는 각 page구간 값의 합친 결과를 저장해놓은 배열
			}
			
			for (int k = 1; k < size; k++) {
                for (int s = 1; s <= size - k; s++) {
                    dp[s][s + k] = Integer.MAX_VALUE;	//s~s+k구간의 최소값을 구하기 위한 초기화
                    for (int j = s; j < s + k ; j++) {
                        dp[s][s + k] = Math.min(dp[s][s + k], dp[s][j] + dp[j+1][s + k]);
                    }						//dp구간중 최소값을 dp의 값에 대입
                	//각 구간의 합친 비용까지 합산
                    dp[s][s + k] += sum[s + k] - sum[s - 1];
                }
            }
			
			System.out.println(dp[1][size]);	//1~size까지의 구간의 최소비용 값
		}
	}
}
