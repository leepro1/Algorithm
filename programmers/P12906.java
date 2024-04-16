package programmers;

import java.util.ArrayDeque;

public class P12906 {
    public int[] solution(int[] arr) {

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(arr[0]);

        for (int i = 1, size = arr.length; i < size; i++) {
            if (arr[i] != arr[i - 1])
                stack.push(arr[i]);
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)
            answer[i] = stack.pop();

        return answer;
    }

}
