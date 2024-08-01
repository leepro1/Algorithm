package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B7662 {

    static int T, K;
    static PriorityQueue<Integer> minHeap; // 오름차순이 기본
    static PriorityQueue<Integer> maxHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            K = Integer.parseInt(br.readLine());

            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            Map<Integer, Integer> map = new HashMap<>();

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (order == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    minHeap.add(num);
                    maxHeap.add(num);

                } else {
                    if (num == -1) {
                        removeElement(minHeap, map);
                    } else {
                        removeElement(maxHeap, map);
                    }
                }
            }

            cleanHeap(minHeap, map);
            cleanHeap(maxHeap, map);

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void removeElement(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int num = heap.poll();
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                break;
            }
        }
    }

    private static void cleanHeap(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty() && !map.containsKey(heap.peek())) {
            heap.poll();
        }
    }
}
