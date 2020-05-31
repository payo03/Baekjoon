import java.io.*;
import java.util.*;

public class CardExample_2164 {

	public static void main(String[] args) throws IOException {
		
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int temp = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=temp; i++) { 
			queue.add(i);
		}
		
		for(int i=0; i<temp; i++) {
			if(queue.size() == 1) {
				System.out.println(queue.poll());
				break;
			}
			queue.poll();
			queue.add(queue.poll());
		}
	}

}
