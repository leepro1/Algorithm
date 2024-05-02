package programmers;

import java.util.*;

class P1845 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        answer = (set.size() > nums.length / 2) ? nums.length / 2 : set.size();
        
        return answer;
    }
}
