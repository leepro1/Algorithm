package programmers;

class P43162 {
    static int[] parents;
    
    static int find(int x){
        if(parents[x] == x)
            return x;
        
        return parents[x] = find(parents[x]);
    }
    
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }
    
    public int solution(int n, int[][] computers) {
        
        parents = new int[n];
        for(int i=0; i<n; i++)
            parents[i]=i;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                   union(i, j); 
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(find(i) == i){
                answer++; 
            }
        }
        
        
        return answer;
    }
}
