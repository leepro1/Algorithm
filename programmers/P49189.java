package programmers;

import java.util.*;

class P49189 {

    static ArrayList<Integer>[] nodeList;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        
        dist = new int[n+1];
        nodeList = new ArrayList[n+1];
        for(int i=1; i< n+1; i++){
            nodeList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i < edge.length; i++){
            nodeList[edge[i][0]].add(edge[i][1]);
            nodeList[edge[i][1]].add(edge[i][0]);
        }
        
        return bfs();
    }
    
    static int bfs(){
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(1);
        dist[1] = 1;
        int max = 1;
        int answer = 0;
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            
            if(dist[temp] > max){
                max = dist[temp];
                answer=0;
            }
            
            if(dist[temp] == max) {
                answer++;
            }
                
            for(int next : nodeList[temp]){
                if(dist[next] == 0){
                    dist[next] = dist[temp] + 1;
                    queue.add(next);
                }
                
            }
            
        }
            
        return answer;
    }
}