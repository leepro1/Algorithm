package programmers;

import java.util.*;

class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Arrays.sort(reserve);
        
        boolean[] check = new boolean[n+2];
        for(int i=0; i<lost.length; i++){
            check[lost[i]] = true;
        }
        
        int loseCnt = 0;
        for(int i=0; i<reserve.length; i++){
            while(loseCnt < lost.length - 1 && lost[loseCnt]<reserve[i]){
                loseCnt++;
            }
            
            if(check[reserve[i]]){
                check[reserve[i]] = false;
                answer++;
            } else if(lost[loseCnt] !=reserve[i] && check[reserve[i] - 1]){
                check[reserve[i] - 1] = false;
                answer++;
            } else if(lost[loseCnt] !=reserve[i] && check[reserve[i] + 1]){
                check[reserve[i] + 1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}