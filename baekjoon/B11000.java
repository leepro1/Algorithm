//https://www.acmicpc.net/problem/11000
/*
 * 강의실 배정 - 그리디, 우선순위 큐
 * 이전에 회의시간 배정 문제에서와는 다르게 우선순위 큐를 사용해본다.
 * 큐의 원소 - 현재 강의실에서의 종룟간
 * 큐의 원소 수 - 강의실 개수
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] lectureTime = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectureTime[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
			lectureTime[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}

		// 람다식을 이용하여 정렬
		Arrays.sort(lectureTime, (o1, o2) -> {
			if (o1[0] == o2[0])
				return o1[1] - o2[1];
			return o1[0] - o2[0];
		});

		PriorityQueue<Integer> pqueue = new PriorityQueue<>();

		pqueue.offer(lectureTime[0][1]);

		for (int i = 1; i < n; i++) {
			int temp = pqueue.peek();

			if (lectureTime[i][0] >= temp) {
				pqueue.poll();
			}

			pqueue.offer(lectureTime[i][1]);
		}
		System.out.println(pqueue.size());
	}
}
