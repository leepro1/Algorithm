package jungol;

//수행시간:231ms       메모리:33,484kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1661 {
	static int X, Y;
	static int[][] map;
	static int startX, startY, goalX, goalY;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	// x, y -> c, r 로 생각
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		goalX = Integer.parseInt(st.nextToken());
		goalY = Integer.parseInt(st.nextToken());

		map = new int[Y + 1][X + 1];
		for (int i = 1; i <= Y; i++) {
			String str = br.readLine();
			for (int j = 1; j <= X; j++) {
				if (str.charAt(j - 1) - '0' == 1)
					map[i][j] = -1;
				else
					map[i][j] = 0;
			}
		}

		map[startY][startX] = 1;
		dfs(startX, startY);

		System.out.println(map[goalY][goalX] - 1);
	}

	public static void dfs(int x, int y) {
		if (x == goalX && y == goalY)
			return;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX > X || nextY > Y || nextX < 1 || nextY < 1)
				continue;

			if (map[nextY][nextX] == 0 || map[nextY][nextX] > map[y][x] + 1) {

				map[nextY][nextX] = map[y][x] + 1;
				dfs(nextX, nextY);
			}
		}

	}
}
