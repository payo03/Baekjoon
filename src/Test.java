
public class Test {
    
    public static void main(String[] args) throws Exception {

    	int a = 3;
    	int b = 5;
    	int c = a + b;
    	double d = 7;
    	
    	print(a);
    	print((double)c);
    	print(d);
    	
    }
    private static void print(double x) {
    	System.out.println(x + " is double");
    }
    private static void print(int x) {
    	System.out.println(x + " is int");
    }
}

