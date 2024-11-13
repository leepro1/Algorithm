package programmers;

import java.util.*;

class P42587 {

    public int solution(int[] priorities, int location) {

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
            pq.add(priorities[i]);
        }

        while (true) {
            int temp = queue.poll();

            if (priorities[temp] < pq.peek()) {
                queue.add(temp);
                temp = -1;
            } else {
                answer++;
                pq.poll();
            }

            if (temp == location) {
                break;
            }
        }

        return answer;
    }
}

