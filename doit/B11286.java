/*
 * https://www.acmicpc.net/problem/11286
 * 절댓값 힙
 * 절댓값이 작은 수를 출력해야하므로 순서와는 상관없다.
 * 절댓값이 같으면 더 작은 수 를 출력하는 우선순위 큐를 이용하자.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((e1, e2) -> {
			int val1 = Math.abs(e1);
			int val2 = Math.abs(e2);

			if (val1 == val2) {
				if (e1 > e2)
					return 1;
				else
					return -1;
			}

			else
				return val1 - val2;
		});

		while (N-- > 0) {
			int operation = Integer.parseInt(br.readLine());

			if (operation != 0) {
				priorityQueue.offer(operation);
			} else {
				if (priorityQueue.isEmpty())
					sb.append(0).append("\n");
				else {
					sb.append(priorityQueue.poll()).append("\n");
				}
			}
		}

		System.out.println(sb);
	}
}
