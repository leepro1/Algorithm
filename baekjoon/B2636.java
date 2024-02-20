package baekjoon;

//수행시간:144ms       메모리:14,860kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2636 {
	static int R, C, time, answer = 0;
	static int[][] matrix;
	static boolean[][] visited;

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		matrix = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		System.out.printf("%d %n%d", time, answer);
	}

	static void bfs() {
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { 0, 0, 0 });
		visited[0][0] = true;

		while (!deque.isEmpty()) {
			int[] temp = deque.poll();

			if (temp[2] > time) {
				answer = 0;
				time++;
			}
			if (matrix[temp[0]][temp[1]] != 0 && temp[2] == time) {
				answer++;
			}
			for (int i = 0; i < 4; i++) {
				int nextR = temp[0] + dr[i];
				int nextC = temp[1] + dc[i];

				if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C || visited[nextR][nextC])
					continue;

				if (matrix[nextR][nextC] == 0) {
					deque.addFirst(new int[] { nextR, nextC, temp[2] });
				} else {
					deque.add(new int[] { nextR, nextC, temp[2] + 1 });
				}

				visited[nextR][nextC] = true;
			}
		}
	}
}
