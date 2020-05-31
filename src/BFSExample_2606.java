import java.io.*;
import java.util.*;

public class BFSExample_2606 {
	
	static int[][] node;	//2차원 배열로 표현, 컴퓨터가 연결되어있을경우 1, 아닐경우 0(ex, 1 - 2일경우 node[1][2] = 1/node[2][1] = 1)
	static int[] check;		//queue순회할때 확인하는 변수
	
	static int bfs(int point) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		check[point] = point;	//문제에서 1번컴퓨터를 통해 바이러스에 걸리는 컴퓨터 수이므로 for문안의 if문에서 조건에 걸리게 된다.
		queue.offer(point);		//add함수와 같은 역활, 컴퓨터 지점(point)를 통해 node배열의 시작점을 지정
		
		int count = 0;
		while(!queue.isEmpty()) {
			int start = queue.poll();	
			
			for(int i=1; i<node.length; i++) {			//배열에 연결(1)되어있는 부분이 있는지 탐색
				if(node[start][i]==1 && check[i]!=1) {	//연결(1)이 되어 있다면, 숙주(12번 라인)혹은 순회한 지점인 아니라면
					queue.offer(i);						//해당 번호지점 queue에 offer(17번 라인)
					check[i] = 1;						//해당 번호지점에 순회했다고 체크
					count++;							//감염된 컴퓨터수 ++
				}
				
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int computer = Integer.parseInt(br.readLine());
		int relation = Integer.parseInt(br.readLine());
		
		node = new int[computer+1][computer+1];
		check = new int[computer+1];
		
		for(int i=1; i<=relation; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			node[first][second] = 1;
			node[second][first] = 1;
		}
		System.out.println(bfs(1));
	}

}
