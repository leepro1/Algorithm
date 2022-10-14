//https://www.acmicpc.net/problem/1011
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int distance = y - x;
			int maxMove = (int) Math.sqrt(distance);

			if (maxMove == Math.sqrt(distance)) {
				sb.append(maxMove * 2 - 1).append('\n');
			} else if (distance <= maxMove * maxMove + maxMove) {
				sb.append(maxMove * 2).append('\n');
			} else {
				sb.append(maxMove * 2 + 1).append('\n');
			}
		}

		System.out.println(sb);

	}
}
