package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class B9019 {
	static String start, end;
	static StringBuilder sb = new StringBuilder();
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			start = st.nextToken();
			end = st.nextToken();

			set = new HashSet<>();
			bfs();

		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<String[]> queue = new ArrayDeque<>();
		queue.add(new String[] { start, "" });

		while (!queue.isEmpty()) {
			String[] temp = queue.poll();

			if (temp[0].equals(end)) {
				sb.append(temp[1] + "\n");
				return;
			}

			int n = Integer.parseInt(temp[0]);

			// D
			int tempNum = n * 2 % 10000;
			if (!set.contains(tempNum)) {
				queue.add(new String[] { tempNum + "", temp[1] + "D" });
				set.add(tempNum);
			}

			// S
			tempNum = (n == 0 ? 9999 : n - 1);
			if (!set.contains(tempNum)) {
				queue.add(new String[] { tempNum + "", temp[1] + "S" });
				set.add(tempNum);
			}
			
			// L
			tempNum = (n / 1000) + (n % 1000) * 10;
			if (!set.contains(tempNum)) {
				queue.add(new String[] { tempNum + "", temp[1] + "L" });
				set.add(tempNum);
			}
			// R
			tempNum = (n % 10 * 1000) + (n / 10);
			if (!set.contains(tempNum)) {
				queue.add(new String[] { tempNum + "", temp[1] + "R" });
				set.add(tempNum);
			}
		}
	}
}
