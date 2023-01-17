//https://www.acmicpc.net/problem/1697
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] visited = new int[100001];

		if (N >= K) { // 수빈이가 동생보다 +방향에 있는 경우
			System.out.println(N - K);
			return;
		}

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(N);
		visited[N] = 0;

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int i = 0; i < 3; i++) {
				int nextX;

				if (i == 0) {
					nextX = temp + 1;
				}

				else if (i == 1) {
					nextX = temp - 1;
				}

				else {
					nextX = temp * 2;
				}

				if (nextX >= 0 && nextX < 100001 && visited[nextX] == 0) {
					visited[nextX] = visited[temp] + 1;
					queue.offer(nextX);
				}

				if (nextX == K) {
					break;
				}
			}
		}
		System.out.println(visited[K]);
	}
}