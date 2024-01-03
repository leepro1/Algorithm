package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S11315 {
	static int n;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static boolean[][] map, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int n;

		String str;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			map = new boolean[n][n];
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				str = br.readLine();
				for (int j = 0; j < n; j++) {
					if (str.charAt(j) == 'o')
						map[i][j] = true;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					//if(map[i][j])
						//bfs(i,j,)
				}
			}
			
			sb.append("#" + t + " " + "\n");
		}
		System.out.println(sb);
	}
}
