/*
 * https://www.acmicpc.net/problem/1715
 * 카드 정렬하기
 * 묶은 값을 다시 원소로 사용할 수 있으므로 그리디 알고리즘과 (최소값)우선순위 큐를 이용하자.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			priorityQueue.offer(Integer.parseInt(br.readLine()));
		}

		long cnt = 0;
		while (priorityQueue.size() != 1) {
			int cardA = priorityQueue.remove();
			int cardB = priorityQueue.remove();
			cnt += cardA + cardB;

			priorityQueue.offer(cardA + cardB);
		}

		System.out.println(cnt);
	}
}
