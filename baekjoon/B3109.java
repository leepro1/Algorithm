package baekjoon;

//수행시간:400ms       메모리:43,956kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109 {
	static int R, C, cnt = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'x')
					map[i][j] = -1;
			}
		}

		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}

		System.out.println(cnt);
	}

	static boolean dfs(int r, int c) {
		if (c == C - 1) {
			cnt++;
			return true;
		}

		for (int i = r - 1; i <= r + 1; i++) {
			if (i < 0 || i >= R || map[i][c + 1] == -1 || map[i][c + 1] == 1)
				continue;

			map[i][c + 1] = 1;
			if (dfs(i, c + 1))
				return true;
		}

		return false;
	}
}
