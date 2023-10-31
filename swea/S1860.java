package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1860 {
	static int[] serviceTime;
	static int n, m, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			serviceTime = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				serviceTime[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(serviceTime);

			sb.append("#" + t + " " + checkFish() + "\n");
		}
		System.out.println(sb);
	}

	public static String checkFish() {
		for (int i = 0; i < n; i++) {
			if (serviceTime[i] / m * k <= i)
				return "Impossible";
		}

		return "Possible";
	}
}
