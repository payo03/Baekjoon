import java.io.*;
import java.util.*;

public class CoinExample_11047 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		int coinkind[] = new int[first];

		int max = 0;
		for (int i = 0; i < coinkind.length; i++) {
			coinkind[i] = Integer.parseInt(br.readLine());
			if(coinkind[i] <= second) {
				max = i;
			}
		}
		
		int count=0;
		for(int i = max; i >= 0; i--) {
			if(second >= coinkind[i]) {
				count += second / coinkind[i];
				second %= coinkind[i];
			}
		}
		
		System.out.println(count);
	}
}
