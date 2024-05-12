package programmers;

import java.util.*;

class P1844 {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        maps[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length || maps[nx][ny] == 0)
                    continue;
                
                if(nx == maps.length - 1  && ny == maps[0].length - 1) {
                    return maps[temp[0]][temp[1]];
                }
                    
                if(maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[temp[0]][temp[1]] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        
        return -1;
    }
}
