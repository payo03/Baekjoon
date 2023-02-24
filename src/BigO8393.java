import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigO8393 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inputNum = Integer.parseInt(br.readLine());
		long result = 0;

		for(int i=1; i<=inputNum; i++) {
			result += i;
		}
		System.out.println(result);
	}
	
}