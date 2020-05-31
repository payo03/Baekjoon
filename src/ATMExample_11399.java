import java.io.*;
import java.util.*;

public class ATMExample_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int people = Integer.parseInt(br.readLine());
		int time[] = new int[people];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<people; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Greedy_lines(time));
	}
	
	public static int Greedy_lines(int[] x) {
		
		int temp = 0;
		int total = 0;
		Arrays.sort(x);
		for(int i=0; i<x.length; i++) {
			temp += x[i];
			total += temp;
		}
		return total;
	}

}