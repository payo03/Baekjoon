import java.util.*;

public class Test {
    
    public static void main(String[] args) throws Exception {
    	
    	int[] scores = {1, 3, 4, 5, 6, 2, 4};
       	ArrayList<Double> list = new ArrayList<>();
       	
       	ArrayList<Double> resultlist = new ArrayList<>();
    	for(int i=0; i<scores.length; i++) {
    		list.add((double) scores[i]);
    	}
    	Collections.sort(list);
    	
    	int result = 0;
    	for(int i=0; i<scores.length; i++) {
    		result += list.get(i);
    	}
    	int average = result/list.size();
    	
    	int out = 0;
    	for(int i=0; i<scores.length; i++) {
    		if(list.get(i) *2 < average) {
    			if(list.get(i) /2 > average) {
    				out = i;
    			}
    		}
    	}
    	
    	for(int i=out; i<scores.length; i++) {
    		resultlist.add((double)list.get(out));
    	}
    	
    	for(int i=0; i<resultlist.size(); i++) {
    		
    	}
    }
    
}

