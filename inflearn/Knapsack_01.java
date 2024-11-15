package inflearn;

public class Knapsack_01 {

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // 모든 물건에 대해 반복
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // 현재 물건을 넣을 수 있는 경우
                    // 현재 물건을 넣지 않는 경우와 넣는 경우 중 최댓값 선택
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};  // 물건들의 무게
        int[] values = {3, 4, 5, 6};   // 물건들의 가치
        int capacity = 8;              // 배낭의 용량

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value: " + maxValue);
    }
}
