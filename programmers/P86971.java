package programmers;

import java.util.*;

class P86971 {
    static ArrayList<Integer>[] nodeList;
    static boolean[][] visited;
    static int num;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        nodeList = new ArrayList[n+1];
        visited = new boolean[n+1][n+1];
        num = n;
        
        for(int i = 1; i <= n; i++){
            nodeList[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            nodeList[wires[i][0]].add(wires[i][1]);
            nodeList[wires[i][1]].add(wires[i][0]);
        }

        // 완전 탐색으로 n개의 모든 node 고려 + 각 node마다 모든 edge 고려
        for(int i = 1; i <= n; i++) {
            for(int j : nodeList[i]) {
                if(!visited[i][j]) 
                    answer = Math.min(answer, countNode(i, j));
                
                visited[i][j] = true;
                visited[j][i] = true;
            }
        }
        
        return answer;
    }
    
    public int countNode(int a, int b) {
        int cnt = 1;
        boolean[] tempVisited = new boolean[num + 1];
        tempVisited[a] = true;
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int temp : nodeList[a]) {
            if(temp == b)
                continue;
            
            queue.add(temp);
            tempVisited[temp] = true;
            cnt++;
        }
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int temp : nodeList[now]) {
                if(tempVisited[temp])
                    continue;
                
                queue.add(temp);
                tempVisited[temp] = true;
                cnt++;
            }
        }
        
        return Math.abs(num - 2 * cnt);
    }
}
