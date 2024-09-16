package programmers;

import java.util.*;

class P340212 {
  
    public int solution(int[] diffs, int[] times, long limit) {
        
        int answer = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            answer = Math.max(answer, diffs[i]);
        }
        
        int start = 1;
        int end = answer;
        
        while(start < end) {
            
            int mid = (start + end) / 2;
            
            if(check(diffs, times, limit, mid)) {
                end = mid;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
            
        }
        
        return answer;
    }
    
    static boolean check(int[] diffs, int[] times, long limit, int level) {
        
        long totalTime = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            
            long time_cur = 0;
            
            if(level >= diffs[i]) {
                time_cur = times[i];
                totalTime += time_cur;
            } else {
                time_cur = (diffs[i] - level) * (times[i - 1] + times[i]) + times[i];
                totalTime += time_cur;
            }
            
            if(totalTime > limit)
                return false;
        }
        
        if(totalTime <= limit)
            return true;
        
        return false;
        
    }
}
