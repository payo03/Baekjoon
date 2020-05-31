import java.io.*;
import java.util.*;

public class HeightWeightExample_7568 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int person = Integer.parseInt(br.readLine());		//첫줄에 받을 사람의 수
		int arr[][] = new int[person][3];					//[사람의수]-[몸무게, 키, 랭크]
		
		for(int i=0; i<person; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());	//[0]은 몸무게
			arr[i][1] = Integer.parseInt(st.nextToken());	//[1]은 키
		}
		
		int rank;
		for(int i=0; i<person; i++) {								//모든사람을 검사(1명~5명)
			rank = 1;												//첫 순위는 1등
			for(int j=0; j<person; j++) {
				if( arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1] )	//ex)i=0/j=0~4 : 55-185와 그뒤에 사람들 비교, 88-186을 만나서 rank++실행
					rank++;
			}
			arr[i][2] = rank;
		}
		
		for(int i=0; i<person; i++) {
			System.out.print(arr[i][2] + " ");
		}
	}

}
