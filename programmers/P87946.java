package programmers;

class P87946 {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    static void dfs(int cnt, int fatigue, int[][] dungeons) {
        if(cnt == dungeons.length) 
            return;
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && fatigue >= dungeons[i][0]) {
                answer = Math.max(answer, cnt+1);
                visited[i] = true;
                dfs(cnt+1, fatigue - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}
