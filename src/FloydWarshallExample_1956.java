import java.io.*;
import java.util.*;

public class FloydWarshallExample_1956 {
	
	//static 함수를 사용하기위해서 미리 변수를 정의해놓기
	static final int INF = 999999;		//INF를 표현하기 위한 수
	static int villageCnt;				//마을의 수
	static int roadCost;				//각 마을간의 도로 거리
	static int[][] map;					//2차원 배열로 A마을->B마을 = [A][B]로 표현, 양방향이 아닌 단방향
	static int result = INF;			//결과값 초기화
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		villageCnt = Integer.parseInt(st.nextToken());
		roadCost = Integer.parseInt(st.nextToken());
		map = new int[villageCnt+1][villageCnt+1];
		
		init();					//method 참조
		
		//마을간의 도로 거리를 설정해주는 for문, init()메서드로 인해 각 마을의 거리는 INF이기 때문
		for(int i=0; i<roadCost; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[start][end] = cost;
		}
		
		floydWarshall();		//method 참조
		
		//각 마을사이클중 최소 마을 사이클의 거리를 찾기위한 방법
		for(int i=1; i<=villageCnt; i++) {
			result = Math.min(map[i][i], result);
		}
		//어떠한 마을도 사이클이 없는경우
		if(result == INF) {
			result = -1;
		}
		
		System.out.println(result);
	}
	
	public static void init() {
		//각 마을간의 거리를 INF로 초기화 시켜놓는 모습, 마을사이에 도로가 없으면 갈 수 없음을 표시
		for(int start=1; start<=villageCnt; start++) {
			for(int end=1; end<=villageCnt; end++) {
				map[start][end] = INF;
			}
		}
	}
	
	public static void floydWarshall() {
		//시작 마을
		for(int start=1; start<=villageCnt; start++) {
			//중간 경유지 마을
			for(int shelter=1; shelter<=villageCnt; shelter++) {
				//도착지 마을
				for(int end=1; end<=villageCnt; end++) {
					//ex)서울로 올라가는 직선 비용 (순천->서울) > 경유해서 서울로 가는 비용 ( 순천->대전  / 대전 + 서울 ) 이라면 경유해서 올라가는 비용을 이용
					if(map[start][end] > map[start][shelter] + map[shelter][end]) {
						map[start][end] = map[start][shelter] + map[shelter][end];
					}
				}
			}
		}
	}
}
