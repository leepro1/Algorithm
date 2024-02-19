package swea;

//수행시간:121ms       메모리:18,476kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5644 {
	static class Person {
		int x;
		int y;
		int sum;

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
			this.sum = 0;
		}
	}

	static class Battery implements Comparable<Battery> {
		int x;
		int y;
		int c;
		int p;

		public Battery(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(Battery o) {
			return o.p - this.p;
		}
	}

	static int M, A;
	static int answer;
	static Battery[] battery;
	static int[] MoveInfoA, MoveInfoB;
	static int[] dx = { 0, 0, 1, 0, -1 };
	static int[] dy = { 0, -1, 0, 1, 0 };
	static Person personA, personB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			// 이동 정보 입력
			MoveInfoA = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				MoveInfoA[i] = Integer.parseInt(st.nextToken());
			}

			MoveInfoB = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) {
				MoveInfoB[i] = Integer.parseInt(st.nextToken());
			}

			// 배터리 입력
			battery = new Battery[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				battery[i] = new Battery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(battery);
			
			personA = new Person(1, 1);
			personB = new Person(10, 10);

			solve();

			answer = personA.sum + personB.sum;

			sb.append("#" + t + " " + answer + "\n");
		}

		System.out.println(sb);
	}

	public static void solve() {
		for (int i = 0; i <= M; i++) {
			personA.x = personA.x + dx[MoveInfoA[i]];
			personA.y = personA.y + dy[MoveInfoA[i]];
			personB.x = personB.x + dx[MoveInfoB[i]];
			personB.y = personB.y + dy[MoveInfoB[i]];

			ArrayList<Battery> batteryA = new ArrayList<>();
			ArrayList<Battery> batteryB = new ArrayList<>();

			for (int j = 0; j < A; j++) {
				if (checkCoverage(battery[j], personA)) {
					batteryA.add(battery[j]);
				}
				if (checkCoverage(battery[j], personB)) {
					batteryB.add(battery[j]);
				}
			}

			if (batteryA.size() != 0 && batteryB.size() != 0) {
				// 겹칠 때
				if (batteryA.get(0) == batteryB.get(0)) {
					if (batteryA.size() > 1 && batteryB.size() == 1) {
						personA.sum += batteryA.get(1).p;
						personB.sum += batteryB.get(0).p;
					} else if (batteryA.size() == 1 && batteryB.size() > 1) {
						personA.sum += batteryA.get(0).p;
						personB.sum += batteryB.get(1).p;
					} else if (batteryA.size() > 1 && batteryB.size() > 1) {

						if (batteryA.get(1).p > batteryB.get(1).p) {
							personA.sum += batteryA.get(1).p;
							personB.sum += batteryB.get(0).p;
						} else {
							personA.sum += batteryA.get(0).p;
							personB.sum += batteryB.get(1).p;
						}
					} else {
						personA.sum += batteryA.get(0).p / 2;
						personB.sum += batteryB.get(0).p / 2;
					}
				} else {
					personA.sum += batteryA.get(0).p;
					personB.sum += batteryB.get(0).p;
				}
			} else if (batteryA.size() != 0) {
				personA.sum += batteryA.get(0).p;
			} else if (batteryB.size() != 0) {
				personB.sum += batteryB.get(0).p;
			}
		}
	}

	public static boolean checkCoverage(Battery b, Person p) {
		if (b.c >= Math.abs(b.x - p.x) + Math.abs(b.y - p.y))
			return true;

		return false;
	}
}
