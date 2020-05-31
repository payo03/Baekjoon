import java.io.*;
import java.util.Stack;

public class StackExample_10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input, sum = 0;
        
        int number = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<number; i++) {
            input = Integer.parseInt(br.readLine());
            
            if(input == 0){
                stack.pop();
            }else if(input !=0 ){
                stack.push(input);
            }
        }
        
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}