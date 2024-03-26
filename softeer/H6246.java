package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H6246 {
	static int n, m;
	static int visited[][];
	static int dest[][];
	static int cnt = 0;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new int[n + 1][n + 1];
		dest = new int[m][2];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				visited[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			visited[x][y] = 2;
			dest[i][0] = x;
			dest[i][1] = y;
		}

		dfs(dest[0][0], dest[0][1], 1);
		System.out.println(cnt);

	}

	static void dfs(int x, int y, int depth) {
		if (depth == m) {
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 1 || nx > n || ny < 1 || ny > n || visited[nx][ny] == 1)
				continue;

			if (visited[nx][ny] == 2) {
				if (nx == dest[depth][0] && ny == dest[depth][1])
					dfs(nx, ny, depth + 1);
				else
					continue;
			}

			else {
				visited[nx][ny] = 1;
				dfs(nx, ny, depth);
				visited[nx][ny] = 0;
			}
		}
	}
}