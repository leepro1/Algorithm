import java.util.*;

class Solution {
    boolean[][] map = new boolean[52][52];
    boolean[][] visited = new boolean[52][52];
    
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        for(int i = 0; i < rectangle.length; i++) {
            fillMap(rectangle[i]);
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {characterX, characterY, 1});
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
        
                if(nx == itemX && nx == itemY)
                    return node[2];
                
                if(checkMap(nx, ny)) {
                    queue.add(new int[] {nx, ny, node[2] + 1});
                    visited[nx][ny] = true;
                    
                }
            }
            
        }
        
        return 0;
    }
    
    private void fillMap(int[] square) {
        for(int i = square[0]; i <= square[2]; i++) {
            for(int j = square[1]; j <= square[3]; j++) {
                map[i][j] = true;
            }
        }
    }
    
    private boolean checkMap(int x, int y) {
        
        if(x < 1 || y < 1 || x > 50 || y > 50 || visited[x][y])
            return false;
        
        int cnt = 0;
        
        for(int i = 0; i < 4; i++) {
            if(map[x + dx[i]][y + dy[i]])
                cnt++;
        }
        if(cnt != 0 && cnt != 4)
            return true;
        
        return false;
    }
}
