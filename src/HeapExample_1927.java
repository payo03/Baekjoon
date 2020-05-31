import java.io.*;
import java.util.*;

public class HeapExample_1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder()); //우선순위큐(큰수)로 정리
		
		for(int i=0; i<count; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number == 0) {
				if(queue.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(queue.poll());
				}
			}else {
				queue.add(number);
			}
		}
		
	}

}
