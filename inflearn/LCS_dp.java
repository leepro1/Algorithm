package inflearn;

public class LCS_dp {

    public static void main(String[] args) {
        String text1 = "ABCBDAB";
        String text2 = "BDCABC";
        System.out.println("LCS: " + findLCS(text1, text2));
    }

    public static String findLCS(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 1. DP 배열 채우기
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 2. LCS 문자열 찾기 (백트래킹)
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                // 공통 문자가 있으면 LCS에 추가하고 왼쪽 위로 이동
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                // 위쪽 값이 더 크면 위로 이동
                i--;
            } else {
                // 왼쪽 값이 더 크면 왼쪽으로 이동
                j--;
            }
        }

        // LCS 문자열을 뒤집어 반환
        return lcs.reverse().toString();
    }
}
