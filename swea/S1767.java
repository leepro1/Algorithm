package swea;

//수행시간: 1,223ms       메모리:107,888kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1767 {
	static int N, answer, answerCnt, tempLength;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	static ArrayList<int[]> coreList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			coreList = new ArrayList<>();
			boolean[][] map = new boolean[N][N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (st.nextToken().equals("1")) {
						map[i][j] = true;

						if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							answerCnt++;
						} else {
							coreList.add(new int[] { i, j });
						}
					}
				}
			}

			solve(0, answerCnt, 0, map);

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static void solve(int depth, int cnt, int length, boolean[][] tempMap) {
		if (depth == coreList.size()) {
			if (cnt > answerCnt) {
				answerCnt = cnt;
				answer = length;
			} else if (cnt == answerCnt)
				answer = Math.min(answer, length);
			return;
		}

		boolean[][] copyMap = new boolean[N][N];

		int[] core = coreList.get(depth);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				copyMap[j] = Arrays.copyOf(tempMap[j], N);
			}
			if (check(core, i, copyMap)) {
				solve(depth + 1, cnt + 1, length + tempLength, copyMap);
			}
		}

		for (int j = 0; j < N; j++) {
			copyMap[j] = Arrays.copyOf(tempMap[j], N);
		}
		solve(depth + 1, cnt, length, copyMap);
	}

	static boolean check(int[] core, int direction, boolean[][] map) {
		int nextX = core[0] + dx[direction];
		int nextY = core[1] + dy[direction];
		tempLength = 0;

		while (true) {
			if (map[nextX][nextY])
				break;

			map[nextX][nextY] = true;
			tempLength++;

			if (nextX == 0 || nextY == 0 || nextX == N - 1 || nextY == N - 1) {
				return true;
			}

			nextX += dx[direction];
			nextY += dy[direction];
		}

		return false;
	}
}
