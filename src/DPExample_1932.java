import java.io.*;
import java.util.*;

public class DPExample_1932 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int height = Integer.parseInt(br.readLine());
		int triangle[][] = new int[height+1][height+1];
		int max = 0;
		
		for(int i=1; i<=height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				System.out.println(j);
				triangle[i][j] = Integer.parseInt(st.nextToken());
				if(j==1) triangle[i][j] = triangle[i-1][j] + triangle[i][j];
				else if(i==j) triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
				else triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
				
				if(max<triangle[i][j]) max = triangle[i][j];
			}
		}
		
		System.out.println(max);
	}

}
