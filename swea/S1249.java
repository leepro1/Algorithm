package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1249 {
	static int n;
	static int[][] map, count;
	static boolean[][] visited;

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			count = new int[n][n];
			visited = new boolean[n][n];

			// 입력부
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			for (int i = 0; i < n; i++) {
				Arrays.fill(count[i], Integer.MAX_VALUE);
			}
			count[0][0] = 0;

			bfs();

			sb.append("#" + t + " " + count[n - 1][n - 1] + "\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		visited[0][0] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp.x + dx[i];
				int nextY = temp.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
					continue;

				else if (!visited[nextX][nextY] || count[nextX][nextY] > count[temp.x][temp.y] + map[nextX][nextY]) {
					count[nextX][nextY] = count[temp.x][temp.y] + map[nextX][nextY];
					queue.add(new Node(nextX, nextY));
					visited[nextX][nextY] = true;
				}
			}
		}
	}
}
