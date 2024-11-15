package inflearn;

// 무제한으로 선택 가능한 냅색
public class Knapsack_unbound {

    public static int unboundedKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];

        for (int w = 0; w <= capacity; w++) {
            for (int i = 0; i < n; i++) {
                if (weights[i] <= w) {
                    // 현재 아이템을 선택하는 경우와 선택하지 않는 경우 중 최댓값
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 4, 6};
        int[] values = {5, 11, 13};
        int capacity = 10;
        System.out.println("Maximum value: " + unboundedKnapsack(weights, values, capacity));
    }
}
