package swea;

//수행시간:147ms       메모리:18,664kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1873 {
	static int H, W, N;
	static char map[][];
	static Tank tank;
	static String playStr;

	// U, D, L, R
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Tank {
		int r;
		int c;
		int head;

		public Tank(int r, int c, char head) {
			this.r = r;
			this.c = c;
			switch (head) {
			case '^':
				this.head = 0;
				break;
			case 'v':
				this.head = 1;
				break;
			case '<':
				this.head = 2;
				break;
			case '>':
				this.head = 3;
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			// map 입력부
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);

					if (str.charAt(j) == '^' || str.charAt(j) == 'v' || str.charAt(j) == '<' || str.charAt(j) == '>') {
						tank = new Tank(i, j, str.charAt(j));
						map[i][j] = '.';
					}
				}
			}

			N = Integer.parseInt(br.readLine());
			playStr = br.readLine();

			play();

			// 탱크 넣기
			switch (tank.head) {
			case 0:
				map[tank.r][tank.c] = '^';
				break;
			case 1:
				map[tank.r][tank.c] = 'v';
				break;
			case 2:
				map[tank.r][tank.c] = '<';
				break;
			case 3:
				map[tank.r][tank.c] = '>';
				break;
			}

			// 출력부
			sb.append("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	static void play() {
		for (int i = 0; i < N; i++) {
			switch (playStr.charAt(i)) {
			case 'S':
				shoot();
				break;
			default:
				move(playStr.charAt(i));
			}
		}
	}

	static void move(char direction) {
		switch (direction) {
		case 'U':
			tank.head = 0;
			break;
		case 'D':
			tank.head = 1;
			break;
		case 'L':
			tank.head = 2;
			break;
		case 'R':
			tank.head = 3;
			break;
		}

		int nextR = tank.r + dr[tank.head];
		int nextC = tank.c + dc[tank.head];

		if (nextR < 0 || nextC < 0 || nextR >= H || nextC >= W || map[nextR][nextC] != '.')
			return;

		tank.r = nextR;
		tank.c = nextC;
	}

	static void shoot() {
		int nextR = tank.r;
		int nextC = tank.c;

		while (true) {
			nextR += dr[tank.head];
			nextC += dc[tank.head];

			if (nextR < 0 || nextC < 0 || nextR >= H || nextC >= W || map[nextR][nextC] == '#')
				return;

			if (map[nextR][nextC] == '*') {
				map[nextR][nextC] = '.';
				return;
			}
		}
	}
}
