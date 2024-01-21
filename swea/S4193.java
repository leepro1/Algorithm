package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4193 {
	static int n;
	static Node start, end;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	static class Node {
		int x, y, time;

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 출발지, 목적지 입력
			st = new StringTokenizer(br.readLine());
			start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			st = new StringTokenizer(br.readLine());
			end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

			sb.append("#" + t + " " + bfs() + "\n");
		}
		System.out.println(sb);

	}

	static int bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			if (tempNode.x == end.x && tempNode.y == end.y) {
				return tempNode.time;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = tempNode.x + dx[i];
				int nextY = tempNode.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
					continue;

				if (visited[nextX][nextY] || map[nextX][nextY] == 1)
					continue;

				if (map[nextX][nextY] == 2 && tempNode.time % 3 != 2) {
					queue.add(new Node(tempNode.x, tempNode.y, tempNode.time + 1));
					continue;
				}

				visited[nextX][nextY] = true;
				queue.add(new Node(nextX, nextY, tempNode.time + 1));
			}
		}
		
		return -1;
	}
}
