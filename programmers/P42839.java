package programmers;

import java.util.*;

class P42839 {
    static boolean[] dp, check, visited;
    static int answer;
    
    public int solution(String numbers) {
        dp = new boolean[10_000_000];
        for(int i = 2; i * i <= 10_000_000; i++) {            
            if(dp[i])
                continue;
            
            for(int j = i * i; j < 10_000_000; j = j + i)
               dp[j] = true;
        }   
        
        answer = 0;
        visited = new boolean[numbers.length()];
        check = new boolean[10_000_000];
        for(int i=1; i <= numbers.length();i++){
           permutation(0, i, "", numbers);
        }
        
        return answer;
    }
    
    static void permutation(int depth, int end, String temp, String numbers){
        if(depth == end){
            int num = Integer.parseInt(temp);
            if(num==1 || num==0)
                return;
            
            if(!check[num] && !dp[num]){
                check[num] = true;
                answer++;
            }
            
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i])
                continue;
            
            visited[i] = true;
            permutation(depth+1, end, temp + numbers.charAt(i), numbers);
            visited[i] = false;
        }
    }
}