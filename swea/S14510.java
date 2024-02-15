package swea;

//수행시간:115ms       메모리:20,292kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14510 {
	static int N, max, odd, even, answer;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			max = 0;
			tree = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}

			answer = 0;
			odd = even = 0;
			for (int i = 0; i < N; i++) {
				int diff = max - tree[i];

				if (diff == 0)
					continue;

				even += diff / 2;
				odd += diff % 2;
			}

			if (odd == even)
				answer = odd * 2;
			else if (odd > even)
				answer = even * 2 + (odd - even) * 2 - 1;
			else {
				int tempDiff = even - odd;
				odd += tempDiff / 3 * 2;
				even -= tempDiff / 3;
				answer = odd * 2;
				if ((even - odd) % 3 == 1)
					answer += 2;
				if ((even - odd) % 3 == 2)
					answer += 3;
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}
