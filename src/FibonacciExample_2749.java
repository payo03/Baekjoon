import java.io.*;

public class FibonacciExample_2749 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Integer.parseInt(br.readLine());
		
		int pisano = 1500000;
		long[] arr = new long[pisano];
		arr[0]=0;
		arr[1]=1;
		
		for(int i=2; i<pisano && i<=num; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % (long)Math.pow(10, 6);	//fibonacci(i)는 수가 너무 커서 계산불가
		}
		
		if(num >= pisano) {
			num %= pisano;
		}
		
		System.out.println(arr[(int)num]);
	}

	static long fibonacci(long num) {
		long fibonacci = 0;
		long back = 1;
		long temp = 1;
		
		if(num==0) {
			return 0;
		}else if(num==1) {
			return 1;
		}else if(num==2) {
			return 1;
		}
		
		for(int i=1; i<num-1; i++) {
			fibonacci = back + temp;
			back = temp;
			temp = fibonacci;
		}
		return fibonacci;
	}
}
