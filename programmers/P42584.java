package programmers;

import java.util.*;

public class P42584 {

    public int[] solution(int[] prices) {

        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);

        for (int i = 1; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;

            }

            stack.push(i);

        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = (n - 1) - index;
        }

        return answer;
    }
}