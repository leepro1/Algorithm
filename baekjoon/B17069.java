package baekjoon;

//수행시간: 132ms       메모리: 14,488kb
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class B17069 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];

		// 입력부
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp
		long[][][] dp = new long[N + 1][N + 1][3];
		dp[1][2][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {

				if (map[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
					dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];

					if (map[i - 1][j] == 0 && map[i][j - 1] == 0)
						dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}
