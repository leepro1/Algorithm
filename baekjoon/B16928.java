package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16928 {
	static int N, M;
	static int[] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[101];
		visited = new boolean[101];

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		bfs();
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 1, 0 });
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 1; i <= 6; i++) {
				int next = temp[0] + i;

				if (visited[next])
					continue;

				if (map[next] != 0) {
					visited[next] = true;
					next = map[next];
				}

				if (next == 100) {
					System.out.println(temp[1] + 1);
					return;
				}
				queue.add(new int[] { next, temp[1] + 1 });
				visited[next] = true;
			}
		}

	}
}
