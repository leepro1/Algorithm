package baekjoon;

//수행시간:216ms       메모리:16,052kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B17135 {
	static int N, M, D, answer, nowRound = 0;

	static Archer[] archerList = new Archer[3];
	static ArrayList<Enemy> enemyList = new ArrayList<>();
	static Enemy[] killEnemy = new Enemy[3];

	static class Archer {
		int r;
		int c;

		public Archer(int r) {
			this.r = r;
		}
	}

	static class Enemy implements Comparable<Enemy> {
		int r;
		int c;
		int round;

		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
			this.round = 0;
		}

		@Override
		public int compareTo(Enemy o) {
			return o.c - this.c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					enemyList.add(new Enemy(i, j));
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			archerList[i] = new Archer(N);
		}

		Collections.sort(enemyList);

		combi(0, 0);

		System.out.println(answer);
	}

	static void combi(int depth, int start) {
		if (depth == 3) {
			play();
			return;
		}

		for (int i = start; i < M; i++) {
			archerList[depth].c = i;
			combi(depth + 1, i + 1);
		}
	}

	static void play() {
		int tempDist, cnt = 0;
		nowRound++;

		Arrays.fill(killEnemy, null);

		for (int n = N; n > 0; n--) {
			for (int a = 0; a < 3; a++) {
				archerList[a].r = n;
				tempDist = D;
				for (Enemy e : enemyList) {
					if (archerList[a].r > e.r && e.round != nowRound && tempDist >= calDist(e, archerList[a])) {
						tempDist = calDist(e, archerList[a]);
						killEnemy[a] = e;
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				if (killEnemy[i] == null || killEnemy[i].round == nowRound)
					continue;

				killEnemy[i].round = nowRound;
				cnt++;
			}
		}

		answer = Math.max(answer, cnt);
	}

	static int calDist(Enemy e, Archer a) {
		return Math.abs(e.r - a.r) + Math.abs(e.c - a.c);
	}
}
