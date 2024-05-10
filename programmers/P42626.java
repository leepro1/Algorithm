package programmers;

import java.util.*;

class P42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int item : scoville){
            pq.add(item);
        }
        
        while(true) {
            if(pq.peek() >= K)
                return answer;
            
            if(pq.size() < 2)
                return -1;
                
            int mix = pq.poll() + 2 * pq.poll();        
            pq.add(mix);
            answer++;
        }        
    }
}
