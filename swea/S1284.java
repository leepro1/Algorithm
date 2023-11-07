package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1284 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int p, q, r, s, w;
		int a, b;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			p = Integer.parseInt(st.nextToken()); // a사 리터당 요금
			q = Integer.parseInt(st.nextToken()); // b사 기본 요금
			r = Integer.parseInt(st.nextToken()); // b사 기본 요금 기준
			s = Integer.parseInt(st.nextToken()); // b사 초과 리터당 요금
			w = Integer.parseInt(st.nextToken()); // 사용량

			a = p * w;
			b = q;
			if (w - r > 0) {
				b += (w - r) * s;
			}

			sb.append("#" + t + " " + Math.min(a, b) + "\n");
		}
		System.out.println(sb);
	}
}
