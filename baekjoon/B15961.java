package baekjoon;

//수행시간:532ms       메모리:170,900kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] visited = new int[d + 1];
		int[] belt = new int[N];

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		visited[c]++;
		int cnt = 1;

		// 첫 구간
		for (int i = 0; i < k; i++) {
			if (visited[belt[i]]++ == 0) {
				cnt++;
			}
		}

		int answer = cnt;
		for (int i = k, j = 0; j < N - 1; i++, j++) {
			if (i >= N)
				i %= N;

			if (--visited[belt[j]] == 0)
				cnt--;

			if (visited[belt[i]]++ == 0)
				cnt++;

			answer = Math.max(answer, cnt);
		}

		System.out.println(answer);
	}
}
