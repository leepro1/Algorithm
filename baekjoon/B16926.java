package baekjoon;

//https://www.acmicpc.net/problem/16926
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B16926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		// map 입력부
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// Math.min(n, m)/2 개의 list필요
		ArrayList<Integer>[] list = new ArrayList[Math.min(n, m) / 2];
		for (int i = 0, size = list.length; i < size; i++) {
			list[i] = new ArrayList<>();
		}

		// list 생성부, 반시계방향
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		boolean[][] visited = new boolean[n][m];

		int x, y;
		for (int k = 0, size = list.length; k < size; k++) {
			int direction = 0;
			x = y = k;

			while (true) {
				int nextX = x + dx[direction % 4];
				int nextY = y + dy[direction % 4];

				if (nextX < k || nextY < k || nextX >= n - k || nextY >= m - k) {
					direction++;
					continue;
				}

				x = nextX;
				y = nextY;
				list[k].add(map[x][y]);
				visited[x][y] = true;

				if (x == k && y == k)
					break;
			}
		}

		// 생성한 list를 통해 돌린 배열 생성
		int[][] answer = new int[n][m];
		for (int k = 0, size = list.length; k < size; k++) {
			int direction = 0;
			x = y = k;
			int cnt = 0;
			int tempSize = list[k].size();

			while (true) {
				int nextX = x + dx[direction % 4];
				int nextY = y + dy[direction % 4];

				if (nextX < k || nextY < k || nextX >= n - k || nextY >= m - k) {
					direction++;
					continue;
				}

				x = nextX;
				y = nextY;

				answer[x][y] = list[k].get((cnt - (r % tempSize) + tempSize) % tempSize);
				cnt++;

				if (x == k && y == k)
					break;

			}
		}

		// 출력부
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
