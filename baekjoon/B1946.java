//https://www.acmicpc.net/problem/1946
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] rank = new int[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				rank[document] = Integer.parseInt(st.nextToken());
			}

			int standard = rank[1]; //
			int cnt = 1;

			for (int i = 2; i <= N; i++) {
				if (rank[i] < standard) {
					standard = rank[i];
					cnt++;
				}
			}

			System.out.println(cnt);
		}

	}
}
