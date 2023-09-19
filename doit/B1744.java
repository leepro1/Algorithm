/*
 * https://www.acmicpc.net/problem/1744
 * 수 묶기
 * 그리디로 최대값 / 최소값만 구하면 된다. 이를 위해 우선순위 큐를 사용하였다.
 * 우선순위 큐는 음수와 양수로 구분하고 곱으로 최대의 답을 만들기 위해 0을 음수로 분류한다.
 * 1은 곱보다는 합 연산이 더 최대값이 되므로 이를 조건문으로 구현해 준다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> plusPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPQ = new PriorityQueue<Integer>();

		while (n-- > 0) {
			int input = Integer.parseInt(br.readLine());
			if (input > 0) {
				plusPQ.offer(input);
			} else {
				minusPQ.offer(input);
			}
		}

		int sum = 0;

		while (minusPQ.size() > 1) {
			int a = minusPQ.poll();
			int b = minusPQ.poll();
			sum += a * b;
		}
		if (!minusPQ.isEmpty()) {
			sum += minusPQ.poll();
		}

		while (plusPQ.size() > 1) {
			int a = plusPQ.poll();
			int b = plusPQ.poll();
			if (b == 1) {
				sum += (a + b);
			} else {
				sum += a * b;
			}
		}
		if (!plusPQ.isEmpty()) {
			sum += plusPQ.poll();
		}

		System.out.println(sum);
	}
}
