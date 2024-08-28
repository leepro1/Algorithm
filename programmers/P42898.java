package programmers;

class P42898 {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = -1;
        }
        
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                
                if(dp[i][j] == -1)
                    continue;
                
                dp[i][j] = dp[i - 1][j] == -1 ? dp[i][j] + 0 : dp[i][j] + dp[i - 1][j];
                dp[i][j] = dp[i][j - 1] == -1 ? dp[i][j] + 0 : dp[i][j] + dp[i][j - 1];   
                dp[i][j] %= 1_000_000_007;
            }
        }
        
        return dp[m][n];
    }
}
