import java.util.*;
import java.util.stream.Collectors;

public class Pocketmon {
    
    public static void main(String[] args) {

        Solution2 sol = new Solution2();

        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        System.out.println();
        System.out.println(sol.solution(nums1));
        System.out.println(sol.solution(nums2));
        System.out.println(sol.solution(nums3));
        System.out.println();
    }
}

class Solution2 {
    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> numList = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        answer = Math.min(numList.size(), nums.length/2);

        return answer;
    }
}