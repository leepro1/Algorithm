package programmers;

import java.util.*;

class P43238 {
    public long solution(int n, int[] times) {
      
        // 시간을 기준으로 이분탐색하여 찾아보자
        
        Arrays.sort(times);
      
        long start = 0;
        long end = times[times.length - 1] * (long) n;
        long answer = end;
        while(start <= end) {
            
            long mid = (start + end) / 2;
            long canNum = checker(mid, times);
            
            if(canNum >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            
        }
        
        return answer;
        
    }
    
    long checker(long mid, int[] times) {
        
        long cnt = 0;
        
        for(int time : times) {
            cnt += (mid / time);
        }
        
        return cnt;
    }
}
