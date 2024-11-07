package programmers;

import java.util.*;

class P42586 {

    public int[] solution(int[] progresses, int[] speeds) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = progresses.length - 1; i >= 0; i--) {

            if ((100 - progresses[i]) % speeds[i] > 0) {
                stack.push((100 - progresses[i]) / speeds[i] + 1);
            } else {
                stack.push((100 - progresses[i]) / speeds[i]);
            }

        }

        ArrayList<Integer> answerList = new ArrayList<>();
        while (!stack.isEmpty()) {
            int cnt = 1;
            int lastDay = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= lastDay) {
                stack.pop();
                cnt++;
            }
            answerList.add(cnt);
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}