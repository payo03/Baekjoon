import java.io.*;
import java.util.*;

public class WIFIExample_2110 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int house = Integer.parseInt(st.nextToken());	//집의 개수
		int wifi = Integer.parseInt(st.nextToken());	//공유기의 개수
		
		int[] location = new int[house];
		for(int i=0; i<house; i++) {
			location[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(location);							//집의 위치를 정렬
		
		int min = 1;									//와이파이 설치 최소거리
		int max = location[house-1] - location[0];		//와이파이 설치 최대거리
		int distance = 0;
		int result = 0;
		
		while(min <= max) {
			int gap = (min+max)/2;			//와이파이는 최소 2개이상 설치해야 하기때문
			int start = location[0];
			int wifi_cnt = 1;				//임시 와이파이 개수
			
			for(int i=1; i<house; i++) {	//와이파이 설치시 다음집으로 넘어감
				distance = location[i]-start;
				if(gap <= distance) {
					++wifi_cnt;
					start = location[i];
				}
			}
			
			if(wifi_cnt >= wifi) {			//임시 와이파이 설치갯수가 본 설치갯수보다 클 경우
				result = gap;
				min = gap + 1;
			}else {							//반대일 경우
				max = gap - 1;
			}
		}
		System.out.println(result);
	}
}
