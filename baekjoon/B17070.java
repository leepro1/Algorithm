package baekjoon;

//수행시간:308ms       메모리:14,892kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070 {
	static int N;
	static int cnt;
	static int[][] matrix;

	// 우, 하, 우하 순서
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		matrix = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 0);

		System.out.println(cnt);
	}

	static void dfs(int r, int c, int direction) {
		if (r == N && c == N) {
			cnt++;
			return;
		}

		boolean flag = false;
		for (int i = 0; i < 3; i++) {

			int nextR = r + dr[i];
			int nextC = c + dc[i];

			if (nextR < 1 || nextC <= 1 || nextR > N || nextC > N)
				continue;

			if (matrix[nextR][nextC] == 1) {
				flag = true;
				continue;
			}

			if (direction == 0 && i == 1)
				continue;

			if (direction == 1 && i == 0)
				continue;

			if (i == 2 && flag)
				continue;

			dfs(nextR, nextC, i);
		}
	}
}
