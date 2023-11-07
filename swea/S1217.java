package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1217 {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int tc, m;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			tc = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			sb.append("#" + tc + " " + calPower(m) + "\n");
		}
		System.out.println(sb);
	}

	static int calPower(int m) {
		if (m == 0)
			return 1;

		return n * calPower(m - 1);
	}
}
